package com.github.lbovolini.escola.repository;

import com.github.lbovolini.escola.dto.AlunoDTO;
import com.github.lbovolini.escola.dto.TurmaDTO;
import com.github.lbovolini.escola.model.Aluno;
import com.github.lbovolini.escola.model.Turma;
import com.github.lbovolini.escola.util.AlunoUtil;
import com.github.lbovolini.escola.util.TurmaUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AlunoRepositoryImpl extends RepositoryBase<Aluno> implements AlunoRepository {

    @Override
    public void delete(int id) {
        String query = "DELETE FROM Aluno a WHERE a.id = " + id;
        executeDelete(query);
    }

    @Override
    public AlunoDTO find(int id) {
        String query = "SELECT a FROM Aluno a WHERE a.id = " + id;
        Aluno aluno = (Aluno)executeSingle(query);

        return AlunoUtil.toDTO(aluno);
    }

    @Override
    public String findPassword(String email) {
        String query = "SELECT a.password FROM Aluno a WHERE a.email = ?1";

        List parameters = new ArrayList();
        parameters.add(email);

        String password = (String)executeSingle(query, parameters);

        return password;
    }

    @Override
    public List<TurmaDTO> findTurmas(int alunoId) {
        String query = "SELECT t FROM AlunoTurma at JOIN Turma t ON at.turma = t.id JOIN Aluno a ON a.id = at.aluno WHERE a.id = " + alunoId;
        List<Turma> turmaList = execute(query);
        List<TurmaDTO> turmaDTOList = turmaList.stream().map(TurmaUtil::toDTO).collect(Collectors.toList());

        return turmaDTOList;
    }

    @Override
    public void save(AlunoDTO alunoDTO) {
        Aluno aluno = AlunoUtil.toModel(alunoDTO);
        super.save(aluno);
    }

    @Override
    public void update(AlunoDTO alunoDTO) {

        AlunoDTO alunoDTO1 = find(alunoDTO.getId());

        if (alunoDTO1 == null) {
            return;
        }

        Aluno aluno = AlunoUtil.toModel(alunoDTO);
        super.update(aluno);
    }

}
