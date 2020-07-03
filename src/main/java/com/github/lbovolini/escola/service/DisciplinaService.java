package com.github.lbovolini.escola.service;

import com.github.lbovolini.escola.dto.DisciplinaDTO;
import com.github.lbovolini.escola.repository.DisciplinaRepository;
import com.github.lbovolini.escola.repository.DisciplinaRepositoryImpl;

public class DisciplinaService {

    private DisciplinaRepository disciplinaRepository;

    public DisciplinaService() {
        this.disciplinaRepository = new DisciplinaRepositoryImpl();
    }

    public void delete(int id) {
        disciplinaRepository.delete(id);
    }

    public DisciplinaDTO find(int id) {
        return disciplinaRepository.find(id);
    }

    public void save(DisciplinaDTO disciplinaDTO) {
        disciplinaRepository.save(disciplinaDTO);
    }

    public void update(DisciplinaDTO disciplinaDTO) {
        disciplinaRepository.update(disciplinaDTO);
    }
}