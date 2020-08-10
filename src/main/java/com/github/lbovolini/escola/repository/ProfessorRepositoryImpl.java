package com.github.lbovolini.escola.repository;

import com.github.lbovolini.escola.dto.ProfessorDTO;
import com.github.lbovolini.escola.model.Professor;
import com.github.lbovolini.escola.util.ProfessorUtil;

import java.util.ArrayList;
import java.util.List;

public class ProfessorRepositoryImpl extends RepositoryBase<Professor> implements ProfessorRepository {
    @Override
    public void delete(int id) {
        String query = "DELETE FROM Professor WHERE id = ?1";

        List parameters = new ArrayList();
        parameters.add(id);

        executeDelete(query, parameters);
    }

    @Override
    public ProfessorDTO find(int id) {
        String query = "SELECT p FROM Professor p WHERE p.id = ?1";

        List parameters = new ArrayList();
        parameters.add(id);

        Professor professor = (Professor)executeSingle(query, parameters);

        return ProfessorUtil.toDTO(professor);
    }

    @Override
    public String findPassword(String email) {
        String query = "SELECT password FROM Professor WHERE email = ?1";
        List parameters = new ArrayList<>();
        parameters.add(email);

        return (String)executeSingle(query, parameters);
    }

    @Override
    public void save(ProfessorDTO professorDTO) {
        Professor professor = ProfessorUtil.toModel(professorDTO);
        super.save(professor);
    }

    @Override
    public void update(ProfessorDTO professorDTO) {
        ProfessorDTO professorDTO1 = find(professorDTO.getId());

        if (professorDTO1 == null) {
            return;
        }

        Professor professor = ProfessorUtil.toModel(professorDTO);
        super.update(professor);
    }
}
