package com.github.lbovolini.escola.repository;

import com.github.lbovolini.escola.dto.DisciplineDTO;
import com.github.lbovolini.escola.dto.CurriculumDTO;
import com.github.lbovolini.escola.model.Discipline;
import com.github.lbovolini.escola.model.Curriculum;
import com.github.lbovolini.escola.util.DisciplineUtil;
import com.github.lbovolini.escola.util.CurriculumUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CurriculumRepositoryImpl extends RepositoryBase<Curriculum> implements CurriculumRepository {
    @Override
    public void delete(int id) {
        String query = "DELETE FROM Curriculum WHERE id = ?1";

        List parameters = new ArrayList();
        parameters.add(id);

        executeDelete(query, parameters);
    }

    @Override
    public CurriculumDTO find(int id) {
        String query = "SELECT g FROM Curriculum g WHERE g.id = ?1";

        List parameters = new ArrayList();
        parameters.add(id);

        Curriculum curriculum = (Curriculum)executeSingle(query, parameters);

        return CurriculumUtil.toDTO(curriculum);
    }

    @Override
    public List<DisciplineDTO> findDisciplinas(int id) {
        String query = "SELECT d FROM Discipline d JOIN DisciplineCurriculum dgc ON d.id = dgc.disciplineId JOIN Curriculum g ON g.id = dgc.curriculumId WHERE g.id = ?1";

        List parameters = new ArrayList();
        parameters.add(id);

        List<Discipline> disciplineList = execute(query, parameters);
        List<DisciplineDTO> disciplineDTOList = disciplineList.stream().map(DisciplineUtil::toDTO).collect(Collectors.toList());

        return disciplineDTOList;
    }

    @Override
    public void save(CurriculumDTO curriculumDTO) {
        Curriculum curriculum = CurriculumUtil.toModel(curriculumDTO);
        super.save(curriculum);
    }

    @Override
    public void update(CurriculumDTO curriculumDTO) {
        CurriculumDTO curriculumDTO1 = find(curriculumDTO.getId());

        if (curriculumDTO1 == null) {
            return;
        }

        Curriculum curriculum = CurriculumUtil.toModel(curriculumDTO);
        super.update(curriculum);
    }
}
