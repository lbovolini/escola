package com.github.lbovolini.escola.repository;

import com.github.lbovolini.escola.dto.AulaDTO;
import com.github.lbovolini.escola.dto.DisciplinaDTO;
import com.github.lbovolini.escola.model.Aula;
import com.github.lbovolini.escola.model.Disciplina;
import com.github.lbovolini.escola.util.AulaUtil;
import com.github.lbovolini.escola.util.DisciplinaUtil;

import java.util.List;
import java.util.stream.Collectors;

public class DisciplinaRepositoryImpl extends RepositoryBase<Disciplina> implements DisciplinaRepository {
    @Override
    public void delete(int id) {
        String query = "DELETE FROM Disciplina WHERE id = " + id;
        executeDelete(query);
    }

    @Override
    public DisciplinaDTO find(int id) {
        String query = "SELECT d FROM Disciplina d WHERE d.id = " + id;
        Disciplina disciplina = (Disciplina)executeSingle(query);

        return DisciplinaUtil.toDTO(disciplina);
    }

    @Override
    public List<AulaDTO> findAulas(int disciplinaId, int alunoId) {
        String query = "SELECT a FROM Aula a JOIN Turma t ON a.Turma_id = t.id JOIN AlunoTurma at ON at.Turma_id = t.id WHERE at.Aluno_id = " + alunoId +" AND a.Disciplina_id = " + disciplinaId;
        List<Aula> aulaList = execute(query);
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
