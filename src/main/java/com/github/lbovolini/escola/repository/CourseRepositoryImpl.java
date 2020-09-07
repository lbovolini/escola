package com.github.lbovolini.escola.repository;

import com.github.lbovolini.escola.dto.CourseDTO;
import com.github.lbovolini.escola.dto.CurriculumDTO;
import com.github.lbovolini.escola.model.Course;
import com.github.lbovolini.escola.model.Curriculum;
import com.github.lbovolini.mapper.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class CourseRepositoryImpl extends RepositoryBase<Course> implements CourseRepository {

    @Override
    public void delete(int id) {
        String query = "DELETE FROM Course c WHERE c.id = ?1";

        List parameters = new ArrayList();
        parameters.add(id);

        executeDelete(query, parameters);
    }

    @Override
    public CourseDTO find(int id) {

        String query = "SELECT c FROM Course c WHERE c.id = ?1";

        List parameters = new ArrayList();
        parameters.add(id);

        Course course = (Course)executeSingle(query, parameters);

        return ObjectMapper.map(course, CourseDTO.class);
    }

    @Override
    public List<CourseDTO> findAll() {

        String query = "SELECT c FROM Course c";
        List<Course> courseList = execute(query);

        return ObjectMapper.map(courseList, CourseDTO.class);
    }

    @Override
    public List<CurriculumDTO> findCurriculum(int id) {
        String query = "SELECT gc FROM Curriculum gc WHERE gc.courseId = ?1";

        List parameters = new ArrayList();
        parameters.add(id);

        List<Curriculum> curriculumList = execute(query, parameters);

        return ObjectMapper.map(curriculumList, CurriculumDTO.class);
    }

    @Override
    public void save(CourseDTO courseDTO) {
        Course course = ObjectMapper.map(courseDTO, Course.class);
        super.save(course);
    }

    @Override
    public void update(CourseDTO courseDTO) {

        CourseDTO courseDTO1 = find(courseDTO.getId());

        if (courseDTO1 == null) {
            return;
        }

        Course course = ObjectMapper.map(courseDTO, Course.class);
        super.update(course);
    }
}
