package com.github.lbovolini.escola.service;

import com.github.lbovolini.escola.dto.CourseDTO;
import com.github.lbovolini.escola.dto.CurriculumDTO;
import com.github.lbovolini.escola.repository.CourseRepository;

import javax.inject.Inject;
import java.util.List;

public class CourseService {

    private final CourseRepository courseRepository;

    @Inject
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void delete(int id) {
        courseRepository.delete(id);
    }

    public CourseDTO find(int id) {
        return courseRepository.find(id);
    }

    public List<CourseDTO> findAll() {
        return courseRepository.findAll();
    }

    public List<CurriculumDTO> findGrandesCurriculares(int id) {
        return courseRepository.findGrandesCurriculares(id);
    }

    public void save(CourseDTO courseDto) {
        courseRepository.save(courseDto);
    }

    public void update(CourseDTO courseDto) {
        courseRepository.update(courseDto);
    }
}
