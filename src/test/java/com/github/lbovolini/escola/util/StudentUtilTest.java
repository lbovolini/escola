package com.github.lbovolini.escola.util;

import com.github.lbovolini.escola.auth.Role;
import com.github.lbovolini.escola.dto.StudentDTO;
import com.github.lbovolini.escola.dto.StudentProfileDTO;
import com.github.lbovolini.escola.dto.UserDTO;
import com.github.lbovolini.escola.exception.InvalidFormException;
import com.github.lbovolini.escola.message.InputError;
import com.github.lbovolini.escola.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.JoinColumn;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

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

    @Test
    void shouldValidateCreateStudentDTO() {

        StudentDTO studentDTO = new StudentDTO();
        //studentDTO.setId(id);
        studentDTO.setName(name);
        studentDTO.setEmail(email);
        studentDTO.setPassword(password);
        studentDTO.setBirthday(birthday);
        studentDTO.setCourseId(courseId);

        assertDoesNotThrow(() -> StudentUtil.validateCreate(studentDTO));
    }

    @Test
    void shouldThrowInvalidFormExceptionCreateStudentDTO() {

        StudentDTO studentDTO = new StudentDTO();
        //studentDTO.setId(0);
        studentDTO.setName(null);
        studentDTO.setEmail(null);
        studentDTO.setPassword(null);
        studentDTO.setBirthday(null);
        studentDTO.setCourseId(0);

        AtomicInteger size = new AtomicInteger(0);
        assertThrows(InvalidFormException.class, () -> {
            try {
                StudentUtil.validateCreate(studentDTO);
            } catch (InvalidFormException e) {
                List<InputError> inputErrorList = e.getErrors();
                size.set(inputErrorList.size());
                throw e;
            }
        });

        assertEquals(5, size.get());
    }

    @Test
    void shouldThrowInvalidFormExceptionCreateStudentDTOPassword() {

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(id);
        studentDTO.setName(name);
        studentDTO.setEmail(email);
        studentDTO.setPassword("password");
        studentDTO.setBirthday(birthday);
        studentDTO.setCourseId(courseId);

        AtomicBoolean error = new AtomicBoolean(false);
        assertThrows(InvalidFormException.class, () -> {
            try {
                StudentUtil.validateCreate(studentDTO);
            } catch (InvalidFormException e) {
                List<InputError> inputErrorList = e.getErrors();
                inputErrorList.stream()
                        .filter(inputError -> inputError.getField().equals("password") && inputError.getError().equals("Password require minimum eight characters, at least one letter and one number"))
                        .findFirst()
                        .ifPresent(inputError -> error.set(true));
                throw e;
            }
        });

        assertTrue(error.get());
    }

    @Test
    void shouldThrowInvalidFormExceptionCreateStudentDTOEmail() {

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(id);
        studentDTO.setName(name);
        studentDTO.setEmail("email");
        studentDTO.setPassword(password);
        studentDTO.setBirthday(birthday);
        studentDTO.setCourseId(courseId);

        AtomicBoolean error = new AtomicBoolean(false);
        assertThrows(InvalidFormException.class, () -> {
            try {
                StudentUtil.validateCreate(studentDTO);
            } catch (InvalidFormException e) {
                List<InputError> inputErrorList = e.getErrors();
                inputErrorList.stream()
                        .filter(inputError -> inputError.getField().equals("email") && inputError.getError().equals("Invalid email address"))
                        .findFirst()
                        .ifPresent(inputError -> error.set(true));
                throw e;
            }
        });

        assertTrue(error.get());
    }

    @Test
    void shouldValidateUpdateStudentDTO() {

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(id);
        studentDTO.setName(name);
        studentDTO.setEmail(email);
        studentDTO.setPassword(password);
        studentDTO.setBirthday(birthday);
        studentDTO.setCourseId(courseId);

        assertDoesNotThrow(() -> StudentUtil.validateUpdate(studentDTO));
    }

    @Test
    void shouldThrowInvalidFormExceptionUpdateStudentDTO() {

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(0);
        studentDTO.setName(null);
        studentDTO.setEmail(null);
        studentDTO.setPassword(null);
        studentDTO.setBirthday(null);
        studentDTO.setCourseId(0);

        AtomicInteger size = new AtomicInteger(0);
        assertThrows(InvalidFormException.class, () -> {
            try {
                StudentUtil.validateUpdate(studentDTO);
            } catch (InvalidFormException e) {
                List<InputError> inputErrorList = e.getErrors();
                size.set(inputErrorList.size());
                throw e;
            }
        });

        assertEquals(6, size.get());
    }

    @Test
    void shouldValidateProfileDTO() {

        StudentProfileDTO studentProfileDTO = new StudentProfileDTO();
        studentProfileDTO.setId(id);
        studentProfileDTO.setName(name);
        studentProfileDTO.setEmail(email);
        studentProfileDTO.setPassword(password);
        studentProfileDTO.setNewPassword(password);
        studentProfileDTO.setBirthday(birthday);

        assertDoesNotThrow(() -> StudentUtil.validateProfile(studentProfileDTO));
    }

    @Test
    void shouldThrowInvalidFormExceptionValidateStudentProfileDTO() {

        StudentProfileDTO studentProfileDTO = new StudentProfileDTO();
        studentProfileDTO.setId(0);
        studentProfileDTO.setName(null);
        studentProfileDTO.setEmail(null);
        studentProfileDTO.setPassword(null);
        studentProfileDTO.setNewPassword(null);
        studentProfileDTO.setBirthday(null);

        AtomicInteger size = new AtomicInteger(0);
        assertThrows(InvalidFormException.class, () -> {
            try {
                StudentUtil.validateProfile(studentProfileDTO);
            } catch (InvalidFormException e) {
                List<InputError> inputErrorList = e.getErrors();
                size.set(inputErrorList.size());
                throw e;
            }
        });

        assertEquals(6, size.get());
    }

    @Test
    void shouldThrowInvalidFormExceptionValidateStudentProfileDTOPassword() {

        StudentProfileDTO studentProfileDTO = new StudentProfileDTO();
        studentProfileDTO.setId(id);
        studentProfileDTO.setName(name);
        studentProfileDTO.setEmail(email);
        studentProfileDTO.setPassword("password");
        studentProfileDTO.setNewPassword("password");
        studentProfileDTO.setBirthday(birthday);

        AtomicInteger size = new AtomicInteger(0);
        assertThrows(InvalidFormException.class, () -> {
            try {
                StudentUtil.validateProfile(studentProfileDTO);
            } catch (InvalidFormException e) {
                List<InputError> inputErrorList = e.getErrors();
                size.set(inputErrorList.size());
                throw e;
            }
        });

        assertEquals(2, size.get());
    }
}