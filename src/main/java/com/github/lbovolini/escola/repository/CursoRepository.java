package com.github.lbovolini.escola.repository;

import com.github.lbovolini.escola.model.Curso;

import java.util.List;

public interface CursoRepository {

    Curso find(int id);

    List<Curso> findAll();

    Curso save(Curso curso);

    void delete(int id);

    void update(Curso curso);
}
