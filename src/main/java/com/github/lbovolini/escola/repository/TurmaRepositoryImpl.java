package com.github.lbovolini.escola.repository;

import com.github.lbovolini.escola.model.Turma;

public class TurmaRepositoryImpl extends RepositoryBase<Turma> implements TurmaRepository {

    @Override
    public void delete(int id) {
        String query = "DELETE FROM Turma t WHERE t.id = " + id;
        executeDelete(query);
    }

    @Override
    public Turma find(int id) {
        String query = "SELECT t FROM Turma t WHERE t.id = " + id;
        return (Turma)executeSingle(query);
    }

    @Override
    public void update(Turma turma) {
        Turma turma1 = find(turma.getId());

        if (turma1 == null) {
            return;
        }

        super.update(turma);
    }

}
