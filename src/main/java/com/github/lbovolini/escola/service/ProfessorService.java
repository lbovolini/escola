package com.github.lbovolini.escola.service;

import com.github.lbovolini.escola.dto.ProfessorDTO;
import com.github.lbovolini.escola.repository.ProfessorRepository;
import com.github.lbovolini.escola.repository.ProfessorRepositoryImpl;

public class ProfessorService {

    private ProfessorRepository professorRepository;

    public ProfessorService() {
        this.professorRepository = new ProfessorRepositoryImpl();
    }

    public void delete(int id) {
        professorRepository.delete(id);
    }

    public ProfessorDTO find(int id) {
        return professorRepository.find(id);
    }

    public void save(ProfessorDTO professorDTO) {
        professorRepository.save(professorDTO);
    }

    public void update(ProfessorDTO professorDTO) {
        professorRepository.update(professorDTO);
    }
}
