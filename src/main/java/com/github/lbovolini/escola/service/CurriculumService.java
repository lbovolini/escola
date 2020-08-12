package com.github.lbovolini.escola.service;

import com.github.lbovolini.escola.dto.DisciplineDTO;
import com.github.lbovolini.escola.dto.CurriculumDTO;
import com.github.lbovolini.escola.repository.CurriculumRepository;

import javax.inject.Inject;
import java.util.List;

public class CurriculumService {

    private final CurriculumRepository curriculumRepository;

    @Inject
    public CurriculumService(CurriculumRepository curriculumRepository) {
        this.curriculumRepository = curriculumRepository;
    }

    public void delete(int id) {
        curriculumRepository.delete(id);
    }

    public CurriculumDTO find(int id) {
        return curriculumRepository.find(id);
    }

    public List<DisciplineDTO> findDisciplinas(int id) {
        return curriculumRepository.findDisciplinas(id);
    }

    public void save(CurriculumDTO curriculumDTO) {
        curriculumRepository.save(curriculumDTO);
    }

    public void update(CurriculumDTO curriculumDTO) {
        curriculumRepository.update(curriculumDTO);
    }
}
