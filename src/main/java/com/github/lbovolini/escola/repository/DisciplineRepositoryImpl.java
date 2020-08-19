package com.github.lbovolini.escola.repository;

import com.github.lbovolini.escola.dto.ClassDTO;
import com.github.lbovolini.escola.dto.DisciplineDTO;
import com.github.lbovolini.escola.model.Class;
import com.github.lbovolini.escola.model.Discipline;
import com.github.lbovolini.mapper.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

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

        return ObjectMapper.map(discipline, DisciplineDTO.class);
    }

    @Override
    public List<ClassDTO> findAulas(int disciplinaId, int alunoId) {
        String query = "SELECT a FROM Class a JOIN Group t ON a.groupId = t.id JOIN StudentGroup at ON at.groupId = t.id WHERE at.studentId = ?1 AND a.disciplineId = ?2";

        List parameters = new ArrayList();
        parameters.add(alunoId);
        parameters.add(disciplinaId);

        List<Class> classList = execute(query, parameters);

        return ObjectMapper.map(classList, ClassDTO.class);
    }

    @Override
    public void save(DisciplineDTO disciplineDTO) {
        Discipline discipline = ObjectMapper.map(disciplineDTO, Discipline.class);
        super.save(discipline);
    }

    @Override
    public void update(DisciplineDTO disciplineDTO) {
        DisciplineDTO disciplineDTO1 = find(disciplineDTO.getId());

        if (disciplineDTO1 == null) {
            return;
        }

        Discipline discipline = ObjectMapper.map(disciplineDTO, Discipline.class);
        super.update(discipline);
    }
}
