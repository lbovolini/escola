package com.github.lbovolini.escola.repository;

import com.github.lbovolini.escola.model.Turma;

public interface TurmaRepository {

    void delete(int id);

    Turma find(int id);

    Turma save(Turma turma);

    void update(Turma turma);
}
