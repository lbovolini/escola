package com.github.lbovolini.escola.service;

import com.github.lbovolini.escola.dto.ClassDTO;
import com.github.lbovolini.escola.dto.DisciplineDTO;
import com.github.lbovolini.escola.repository.DisciplineRepository;

import javax.inject.Inject;
import java.util.List;

public class DisciplineService {

    private final DisciplineRepository disciplineRepository;

    @Inject
    public DisciplineService(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }

    public void delete(int id) {
        disciplineRepository.delete(id);
    }

    public DisciplineDTO find(int id) {
        return disciplineRepository.find(id);
    }

    public List<ClassDTO> findAulas(int disciplinaId, int alunoId) {
        return disciplineRepository.findAulas(disciplinaId, alunoId);
    }
    
    public void save(DisciplineDTO disciplineDTO) {
        disciplineRepository.save(disciplineDTO);
    }

    public void update(DisciplineDTO disciplineDTO) {
        disciplineRepository.update(disciplineDTO);
    }
}
