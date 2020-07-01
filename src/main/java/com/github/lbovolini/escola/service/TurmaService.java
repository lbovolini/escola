package com.github.lbovolini.escola.service;

import com.github.lbovolini.escola.dto.TurmaDTO;
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
