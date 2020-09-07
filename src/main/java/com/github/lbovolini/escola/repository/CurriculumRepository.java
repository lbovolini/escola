package com.github.lbovolini.escola.repository;

import com.github.lbovolini.escola.dto.DisciplineDTO;
import com.github.lbovolini.escola.dto.CurriculumDTO;

import java.util.List;

public interface CurriculumRepository {

    void delete(int id);

    CurriculumDTO find(int id);

    List<DisciplineDTO> findDisciplines(int id);

    void save(CurriculumDTO curriculumDTO);

    void update(CurriculumDTO curriculumDTO);
}
