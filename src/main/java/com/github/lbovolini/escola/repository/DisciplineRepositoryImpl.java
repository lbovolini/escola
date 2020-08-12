package com.github.lbovolini.escola.repository;

import com.github.lbovolini.escola.dto.ClassDTO;
import com.github.lbovolini.escola.dto.DisciplineDTO;
import com.github.lbovolini.escola.model.Class;
import com.github.lbovolini.escola.model.Discipline;
import com.github.lbovolini.escola.util.ClassUtil;
import com.github.lbovolini.escola.util.DisciplineUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DisciplineRepositoryImpl extends RepositoryBase<Discipline> implements DisciplineRepository {
    @Override
    public void delete(int id) {
        String query = "DELETE FROM Discipline WHERE id = ?1";

        List parameters = new ArrayList();
        parameters.add(id);

        executeDelete(query, parameters);
    }

    @Override
    public DisciplineDTO find(int id) {
        String query = "SELECT d FROM Discipline d WHERE d.id = ?1";

        List parameters = new ArrayList();
        parameters.add(id);

        Discipline discipline = (Discipline)executeSingle(query, parameters);

        return DisciplineUtil.toDTO(discipline);
    }

    @Override
    public List<ClassDTO> findAulas(int disciplinaId, int alunoId) {
        String query = "SELECT a FROM Class a JOIN Group t ON a.groupId = t.id JOIN StudentGroup at ON at.groupId = t.id WHERE at.studentId = ?1 AND a.disciplineId = ?2";

        List parameters = new ArrayList();
        parameters.add(alunoId);
        parameters.add(disciplinaId);

        List<Class> classList = execute(query, parameters);
        List<ClassDTO> classDTOList = classList.stream().map(ClassUtil::toDTO).collect(Collectors.toList());

        return classDTOList;
    }

    @Override
    public void save(DisciplineDTO disciplineDTO) {
        Discipline discipline = DisciplineUtil.toModel(disciplineDTO);
        super.save(discipline);
    }

    @Override
    public void update(DisciplineDTO disciplineDTO) {
        DisciplineDTO disciplineDTO1 = find(disciplineDTO.getId());

        if (disciplineDTO1 == null) {
            return;
        }

        Discipline discipline = DisciplineUtil.toModel(disciplineDTO);
        super.update(discipline);
    }
}
