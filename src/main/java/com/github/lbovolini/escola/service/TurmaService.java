package com.github.lbovolini.escola.service;

import com.github.lbovolini.escola.dto.TurmaDTO;
import com.github.lbovolini.escola.repository.TurmaRepository;

import javax.inject.Inject;

public class TurmaService {

    private final TurmaRepository turmaRepository;

    @Inject
    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    public void delete(int id) {
        turmaRepository.delete(id);
    }

    public TurmaDTO find(int id) {
        return turmaRepository.find(id);
    }

    public void save(TurmaDTO turmaDTO) {
        turmaRepository.save(turmaDTO);
    }

    public void update(TurmaDTO turmaDTO) {
        turmaRepository.update(turmaDTO);
    }

}
