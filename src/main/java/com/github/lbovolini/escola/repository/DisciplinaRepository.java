package com.github.lbovolini.escola.repository;

import com.github.lbovolini.escola.dto.AulaDTO;
import com.github.lbovolini.escola.dto.DisciplinaDTO;

import java.util.List;

public interface DisciplinaRepository {
    
    void delete(int id);

    DisciplinaDTO find(int id);

    List<AulaDTO> findAulas(int disciplinaId, int alunoId);

    void save(DisciplinaDTO disciplinaDTO);

    void update(DisciplinaDTO disciplinaDTO);
}
