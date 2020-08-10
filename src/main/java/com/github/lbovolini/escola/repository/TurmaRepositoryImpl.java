package com.github.lbovolini.escola.repository;

import com.github.lbovolini.escola.dto.TurmaDTO;
import com.github.lbovolini.escola.model.Turma;
import com.github.lbovolini.escola.util.TurmaUtil;

import java.util.ArrayList;
import java.util.List;

public class TurmaRepositoryImpl extends RepositoryBase<Turma> implements TurmaRepository {

    @Override
    public void delete(int id) {
        String query = "DELETE FROM Turma t WHERE t.id = ?1";

        List parameters = new ArrayList();
        parameters.add(id);

        executeDelete(query, parameters);
    }

    @Override
    public TurmaDTO find(int id) {
        String query = "SELECT t FROM Turma t WHERE t.id = ?1";

        List parameters = new ArrayList();
        parameters.add(id);

        Turma turma = (Turma)executeSingle(query, parameters);

        return TurmaUtil.toDTO(turma);
    }

    @Override
    public void save(TurmaDTO turmaDTO) {
        Turma turma = TurmaUtil.toModel(turmaDTO);
        super.save(turma);
    }

    @Override
    public void update(TurmaDTO turmaDTO) {
        TurmaDTO turmaDTO1 = find(turmaDTO.getId());

        if (turmaDTO1 == null) {
            return;
        }

        Turma turma = TurmaUtil.toModel(turmaDTO);
        super.update(turma);
    }

}
