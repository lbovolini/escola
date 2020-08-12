package com.github.lbovolini.escola.util;

import com.github.lbovolini.escola.dto.CourseDTO;
import com.github.lbovolini.escola.model.Course;

public class CourseUtil {

    public static CourseDTO toDTO(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setName(course.getName());

        return courseDTO;
    }

    public static Course toModel(CourseDTO courseDTO) {
        Course course = new Course();
        course.setId(courseDTO.getId());
        course.setName(courseDTO.getName());

        return course;
    }
}
