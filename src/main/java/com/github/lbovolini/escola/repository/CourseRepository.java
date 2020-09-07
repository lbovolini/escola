package com.github.lbovolini.escola.repository;

import com.github.lbovolini.escola.dto.CourseDTO;
import com.github.lbovolini.escola.dto.CurriculumDTO;

import java.util.List;

public interface CourseRepository {

    void delete(int id);

    CourseDTO find(int id);

    List<CourseDTO> findAll();

    List<CurriculumDTO> findCurriculum(int id);

    void save(CourseDTO courseDTO);

    void update(CourseDTO courseDTO);
}
