package com.github.lbovolini.escola.validation;

import com.github.lbovolini.escola.dto.StudentDTO;
import com.github.lbovolini.escola.dto.StudentProfileDTO;
import com.github.lbovolini.escola.exception.InvalidFormException;
import com.github.lbovolini.escola.message.InputError;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class StudentValidationTest {

    private final int id = 1;
    private final String name = "Lucas Bovolini";
    private final String email = "lucasbovolini@hotmail.com";
    private final String password = "password123";
    private final LocalDate birthday = LocalDate.of(1994, 7, 18);
    private final int courseId = 1;

    @Test
    void shouldValidateCreateStudentDTO() {

        StudentDTO studentDTO = new StudentDTO();
        //studentDTO.setId(id);
        studentDTO.setName(name);
        studentDTO.setEmail(email);
        studentDTO.setPassword(password);
        studentDTO.setBirthday(birthday);
        studentDTO.setCourseId(courseId);

        assertDoesNotThrow(() -> StudentValidation.onCreate(studentDTO));
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
                StudentValidation.onCreate(studentDTO);
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
                StudentValidation.onCreate(studentDTO);
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
                StudentValidation.onCreate(studentDTO);
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

        assertDoesNotThrow(() -> StudentValidation.onUpdate(studentDTO));
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
                StudentValidation.onUpdate(studentDTO);
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

        assertDoesNotThrow(() -> StudentValidation.onUpdateProfile(studentProfileDTO));
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
                StudentValidation.onUpdateProfile(studentProfileDTO);
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
                StudentValidation.onUpdateProfile(studentProfileDTO);
            } catch (InvalidFormException e) {
                List<InputError> inputErrorList = e.getErrors();
                size.set(inputErrorList.size());
                throw e;
            }
        });

        assertEquals(2, size.get());
    }
}