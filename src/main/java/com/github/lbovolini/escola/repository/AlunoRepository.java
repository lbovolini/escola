package com.github.lbovolini.escola.repository;

import com.github.lbovolini.escola.dto.AlunoDTO;

public interface AlunoRepository {

    void delete(int id);

    AlunoDTO find(int id);

    String findPassword(String email);

    void save(AlunoDTO aluno);

    void update(AlunoDTO alunoDTO);
}
