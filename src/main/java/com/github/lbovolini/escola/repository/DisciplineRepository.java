package com.github.lbovolini.escola.repository;

import com.github.lbovolini.escola.dto.ClassDTO;
import com.github.lbovolini.escola.dto.DisciplineDTO;

import java.util.List;

public interface DisciplineRepository {
    
    void delete(int id);

    DisciplineDTO find(int id);

    List<ClassDTO> findAulas(int disciplinaId, int alunoId);

    void save(DisciplineDTO disciplineDTO);

    void update(DisciplineDTO disciplineDTO);
}
