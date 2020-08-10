package com.github.lbovolini.escola.repository;

import com.github.lbovolini.escola.dto.AulaDTO;
import com.github.lbovolini.escola.dto.DisciplinaDTO;
import com.github.lbovolini.escola.model.Aluno;
import com.github.lbovolini.escola.model.Aula;
import com.github.lbovolini.escola.model.Disciplina;
import com.github.lbovolini.escola.util.AulaUtil;
import com.github.lbovolini.escola.util.DisciplinaUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DisciplinaRepositoryImpl extends RepositoryBase<Disciplina> implements DisciplinaRepository {
    @Override
    public void delete(int id) {
        String query = "DELETE FROM Disciplina WHERE id = ?1";

        List parameters = new ArrayList();
        parameters.add(id);

        executeDelete(query, parameters);
    }

    @Override
    public DisciplinaDTO find(int id) {
        String query = "SELECT d FROM Disciplina d WHERE d.id = ?1";

        List parameters = new ArrayList();
        parameters.add(id);

        Disciplina disciplina = (Disciplina)executeSingle(query, parameters);

        return DisciplinaUtil.toDTO(disciplina);
    }

    @Override
    public List<AulaDTO> findAulas(int disciplinaId, int alunoId) {
        String query = "SELECT a FROM Aula a JOIN Turma t ON a.turma = t.id JOIN AlunoTurma at ON at.turma = t.id WHERE at.aluno = ?1 AND a.disciplina = ?2";

        List parameters = new ArrayList();
        parameters.add(new Aluno(alunoId));
        parameters.add(new Disciplina(disciplinaId));

        List<Aula> aulaList = execute(query, parameters);
        List<AulaDTO> aulaDTOList = aulaList.stream().map(AulaUtil::toDTO).collect(Collectors.toList());

        return aulaDTOList;
    }

    @Override
    public void save(DisciplinaDTO disciplinaDTO) {
        Disciplina disciplina = DisciplinaUtil.toModel(disciplinaDTO);
        super.save(disciplina);
    }

    @Override
    public void update(DisciplinaDTO disciplinaDTO) {
        DisciplinaDTO disciplinaDTO1 = find(disciplinaDTO.getId());

        if (disciplinaDTO1 == null) {
            return;
        }

        Disciplina disciplina = DisciplinaUtil.toModel(disciplinaDTO);
        super.update(disciplina);
    }
}
