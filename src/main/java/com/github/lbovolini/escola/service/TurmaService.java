package com.github.lbovolini.escola.service;

import com.github.lbovolini.escola.dto.TurmaDTO;
import com.github.lbovolini.escola.model.Turma;
import com.github.lbovolini.escola.repository.TurmaRepository;
import com.github.lbovolini.escola.repository.TurmaRepositoryImpl;

public class TurmaService {

    private TurmaRepository turmaRepository;

    public TurmaService() {
        this.turmaRepository = new TurmaRepositoryImpl();
    }

    public void delete(int id) {
        turmaRepository.delete(id);
    }

    public Turma find(int id) {
        return turmaRepository.find(id);
    }

    public void save(TurmaDTO turmaDTO) {
        Turma turma = new Turma();
        turma.setNumber(turmaDTO.number);
        turma.setCurso(turmaDTO.curso);

        turmaRepository.save(turma);
    }

    public void update(TurmaDTO turmaDTO) {
        Turma turma = new Turma();
        turma.setId(turmaDTO.id);
        turma.setNumber(turmaDTO.number);
        turma.setCurso(turmaDTO.curso);

        turmaRepository.update(turma);
    }

}
