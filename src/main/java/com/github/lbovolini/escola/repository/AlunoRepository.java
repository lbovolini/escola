package com.github.lbovolini.escola.repository;

import com.github.lbovolini.escola.dto.AlunoDTO;
import com.github.lbovolini.escola.dto.AlunoProfileDTO;
import com.github.lbovolini.escola.dto.DisciplinaDTO;
import com.github.lbovolini.escola.dto.TurmaDTO;

import java.util.List;

public interface AlunoRepository {

    void delete(int id);

    AlunoDTO find(int id);

    AlunoDTO findByEmail(String email);

    List<DisciplinaDTO> findDisciplinas(int id);

    String findPassword(String email);

    List<TurmaDTO> findTurmas(int id);

    void save(AlunoDTO aluno);

    void update(AlunoDTO alunoDTO);

    void updateProfile(AlunoProfileDTO alunoProfileDTO);

    void updateProfileAndPassword(AlunoProfileDTO alunoProfileDTO);
}
