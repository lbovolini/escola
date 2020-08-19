package com.github.lbovolini.escola.repository;

import com.github.lbovolini.escola.dto.DisciplineDTO;
import com.github.lbovolini.escola.dto.CurriculumDTO;
import com.github.lbovolini.escola.model.Discipline;
import com.github.lbovolini.escola.model.Curriculum;
import com.github.lbovolini.mapper.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

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

        return ObjectMapper.map(curriculum, CurriculumDTO.class);
    }

    @Override
    public List<DisciplineDTO> findDisciplinas(int id) {
        String query = "SELECT d FROM Discipline d JOIN DisciplineCurriculum dgc ON d.id = dgc.disciplineId JOIN Curriculum g ON g.id = dgc.curriculumId WHERE g.id = ?1";

        List parameters = new ArrayList();
        parameters.add(id);

        List<Discipline> disciplineList = execute(query, parameters);

        return ObjectMapper.map(disciplineList, DisciplineDTO.class);
    }

    @Override
    public void save(CurriculumDTO curriculumDTO) {
        Curriculum curriculum = ObjectMapper.map(curriculumDTO, Curriculum.class);
        super.save(curriculum);
    }

    @Override
    public void update(CurriculumDTO curriculumDTO) {
        CurriculumDTO curriculumDTO1 = find(curriculumDTO.getId());

        if (curriculumDTO1 == null) {
            return;
        }

        Curriculum curriculum = ObjectMapper.map(curriculumDTO, Curriculum.class);
        super.update(curriculum);
    }
}
