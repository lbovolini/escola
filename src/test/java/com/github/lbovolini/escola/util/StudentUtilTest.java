package com.github.lbovolini.escola.util;

import com.github.lbovolini.escola.auth.Role;
import com.github.lbovolini.escola.dto.StudentDTO;
import com.github.lbovolini.escola.dto.UserDTO;
import com.github.lbovolini.escola.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.JoinColumn;
import java.lang.reflect.Field;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class StudentUtilTest {

    private final int id = 1;
    private final String name = "Lucas Bovolini";
    private final String email = "lucasbovolini@hotmail.com";
    private final String password = "password123";
    private final LocalDate birthday = LocalDate.of(1994, 7, 18);
    private final int courseId = 1;
    private final String role = Role.student();
    private final String token = "token";

    @BeforeEach
    public void init() {
    }

    @Test
    void shouldConvertStudentModelToDTO() {

        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setEmail(email);
        student.setPassword(password);
        student.setBirthday(birthday);
        student.setCursoId(courseId);

        StudentDTO studentDTO = StudentUtil.toDTO(student);

        assertEquals(id, studentDTO.getId());
        assertEquals(name, studentDTO.getName());
        assertEquals(email, studentDTO.getEmail());
        assertEquals(password, studentDTO.getPassword());
        assertEquals(birthday, studentDTO.getBirthday());
        assertEquals(courseId, studentDTO.getCourseId());
    }

    @Test
    void shouldConvertStudentDTOTOModel() {

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(id);
        studentDTO.setName(name);
        studentDTO.setEmail(email);
        studentDTO.setPassword(password);
        studentDTO.setBirthday(birthday);
        studentDTO.setCourseId(courseId);

        Student student = StudentUtil.toModel(studentDTO);

        assertEquals(id, student.getId());
        assertEquals(name, student.getName());
        assertEquals(email, student.getEmail());
        assertEquals(password, student.getPassword());
        assertEquals(birthday, student.getBirthday());
        assertEquals(courseId, student.getCursoId());
    }

    @Test
    void shouldConvertAllAttributes() {

        Field[] studentAttributes = Student.class.getDeclaredFields();

        int studentAttributesSize = 0;
        for (Field attribute: studentAttributes) {
            if (attribute.getDeclaredAnnotation(JoinColumn.class) == null) {
                studentAttributesSize++;
            }
        }

        Field[] studentDTOAttributes = StudentDTO.class.getDeclaredFields();

        int studentDTOAttributesSize = 0;
        for (Field attribute: studentDTOAttributes) {
            studentDTOAttributesSize++;
        }

        assertEquals(studentAttributesSize, studentDTOAttributesSize);
    }

    @Test
    void shouldConvertStudentDTOToUserDTO() {

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(id);
        studentDTO.setName(name);
        studentDTO.setEmail(email);
        studentDTO.setPassword(password);
        studentDTO.setBirthday(birthday);
        studentDTO.setCourseId(courseId);

        UserDTO userDTO = StudentUtil.toUserDTO(studentDTO, role, token);

        assertEquals(id, userDTO.getId());
        assertEquals(name, userDTO.getName());
        assertEquals(email, userDTO.getEmail());
        assertEquals(role, userDTO.getRole());
        assertEquals(token, userDTO.getToken());
    }
}