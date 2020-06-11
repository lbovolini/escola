package com.github.lbovolini.escola.repository;

import com.github.lbovolini.escola.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoRepositoryImpl extends RepositoryBase<Aluno> implements AlunoRepository {

    @Override
    public void delete(int id) {
        String query = "DELETE FROM Aluno a WHERE a.id = " + id;

        executeDelete(query);
    }

    @Override
    public Aluno find(int id) {

        String query = "SELECT a FROM Aluno a WHERE a.id = " + id;

        Aluno aluno = (Aluno)executeSingle(query);

        return aluno;
    }

    @Override
    public void update(Aluno aluno) {

        Aluno aluno1 = find(aluno.getId());

        if (aluno1 == null) {
            return;
        }

        super.update(aluno);
    }

    @Override
    public String findPassword(String email) {
        String query = "SELECT a.password FROM Aluno a WHERE a.email = ?1";

        List parameters = new ArrayList();
        parameters.add(email);

        String password = (String)executeSingle(query, parameters);

        return password;
    }
}
