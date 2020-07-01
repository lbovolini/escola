package com.github.lbovolini.escola.repository;

import com.github.lbovolini.escola.dto.TurmaDTO;

public interface TurmaRepository {

    void delete(int id);

    TurmaDTO find(int id);

    void save(TurmaDTO turmaDTO);

    void update(TurmaDTO turmaDTO);
}
