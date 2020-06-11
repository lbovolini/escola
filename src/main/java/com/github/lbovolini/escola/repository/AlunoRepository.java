package com.github.lbovolini.escola.repository;

import com.github.lbovolini.escola.model.Aluno;

public interface AlunoRepository {

    Aluno find(int id);

    Aluno save(Aluno aluno);

    void delete(int id);

    void update(Aluno aluno);

    String findPassword(String email);
}
