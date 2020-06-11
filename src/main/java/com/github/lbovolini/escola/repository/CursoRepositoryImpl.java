package com.github.lbovolini.escola.repository;

import com.github.lbovolini.escola.model.Curso;

import java.util.List;

public class CursoRepositoryImpl extends RepositoryBase<Curso> implements CursoRepository {

    @Override
    public List<Curso> findAll() {

        String query = "Select c from Curso c";

        List result = execute(query);

        return result;
    }

    @Override
    public Curso find(int id) {

        String query = "SELECT c FROM Curso c WHERE c.id = " + id;

        Curso curso = (Curso)executeSingle(query);

        return curso;
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM Curso c WHERE c.id = " + id;

        executeDelete(query);
    }

    @Override
    public void update(Curso curso) {

        Curso curso1 = find(curso.getId());

        if (curso1 == null) {
            return;
        }

        super.update(curso);
    }
}
