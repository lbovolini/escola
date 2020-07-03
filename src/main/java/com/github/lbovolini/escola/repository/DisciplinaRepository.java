package com.github.lbovolini.escola.repository;

import com.github.lbovolini.escola.dto.DisciplinaDTO;

public interface DisciplinaRepository {
    
    void delete(int id);

    DisciplinaDTO find(int id);

    void save(DisciplinaDTO disciplinaDTO);

    void update(DisciplinaDTO disciplinaDTO);
}
