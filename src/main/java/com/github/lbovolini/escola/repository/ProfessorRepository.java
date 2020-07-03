package com.github.lbovolini.escola.repository;

import com.github.lbovolini.escola.dto.ProfessorDTO;

public interface ProfessorRepository {
    
    void delete(int id);

    ProfessorDTO find(int id);

    void save(ProfessorDTO professorDTO);

    void update(ProfessorDTO professorDTO);
}
