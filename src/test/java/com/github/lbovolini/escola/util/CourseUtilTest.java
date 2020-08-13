package com.github.lbovolini.escola.util;

import com.github.lbovolini.escola.dto.CourseDTO;
import com.github.lbovolini.escola.model.Course;
import org.junit.jupiter.api.Test;

import javax.persistence.JoinColumn;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class CourseUtilTest {

    private final int id = 1;
    private final String name = "Sistemas de Informação";

    @Test
    void shouldConvertCourseModelToDTO() {
        Course course = new Course();
        course.setId(id);
        course.setName(name);

        CourseDTO courseDTO = CourseUtil.toDTO(course);

        assertEquals(id, courseDTO.getId());
        assertEquals(name, courseDTO.getName());
    }

    @Test
    void shouldConvertCourseDTOToModel() {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(id);
        courseDTO.setName(name);

        Course course = CourseUtil.toModel(courseDTO);

        assertEquals(id, course.getId());
        assertEquals(name, course.getName());
    }

    @Test
    void shouldConvertAllAttributes() {

        Field[] courseAttributes = Course.class.getDeclaredFields();

        int courseAttributesSize = 0;
        for (Field attribute: courseAttributes) {
            if (attribute.getDeclaredAnnotation(JoinColumn.class) == null) {
                courseAttributesSize++;
            }
        }

        Field[] courseDTOAttributes = CourseDTO.class.getDeclaredFields();

        int courseDTOAttributesSize = 0;
        for (Field attribute: courseDTOAttributes) {
            courseDTOAttributesSize++;
        }

        assertEquals(courseAttributesSize, courseDTOAttributesSize);
    }
}