package com.github.lbovolini.escola.util;

import com.github.lbovolini.escola.dto.StudentDTO;
import com.github.lbovolini.escola.dto.StudentProfileDTO;
import com.github.lbovolini.escola.dto.UserDTO;
import com.github.lbovolini.escola.exception.InvalidFormException;
import com.github.lbovolini.escola.message.InputError;
import com.github.lbovolini.escola.model.Student;

import java.time.LocalDate;
import java.util.*;

public class StudentUtil {

    public static StudentDTO toDTO(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setPassword(student.getPassword());
        studentDTO.setBirthday(student.getBirthday());
        studentDTO.setCourseId(student.getCursoId());

        return studentDTO;
    }

    public static Student toModel(StudentDTO studentDTO) {
        Student student = new Student();
        student.setId(studentDTO.getId());
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());
        student.setPassword(studentDTO.getPassword());
        student.setBirthday(studentDTO.getBirthday());
        student.setCursoId(studentDTO.getCourseId());

        return student;
    }

    public static UserDTO toUserDTO(StudentDTO studentDTO, String role, String token) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(studentDTO.getId());
        userDTO.setName(studentDTO.getName());
        userDTO.setEmail(studentDTO.getEmail());
        userDTO.setRole(role);
        userDTO.setToken(token);

        return userDTO;
    }

    public static void validateCreate(StudentDTO studentDTO) {
        validateCreate(studentDTO, new ArrayList<>());
    }

    private static void validateCreate(StudentDTO studentDTO, List<InputError> errors) {

        String name = studentDTO.getName();
        if (name == null || name.isEmpty()) {
            errors.add(new InputError("name", "Name is required"));
        }

        String email = studentDTO.getEmail();
        if (email == null || email.isEmpty()) {
            errors.add(new InputError("email", "Email is required"));
        }
        else {
            if (!email.matches("^\\S+@\\S+$")) {
                errors.add(new InputError("email", "Invalid email address"));
            }
        }

        String password = studentDTO.getPassword();
        if (password == null || password.isEmpty()) {
            errors.add(new InputError("password", "Password is required"));
        }
        else {
            if (!password.matches("[\\$\\S+\\$\\S+\\$\\S+]{60}")) {
                if (!password.matches("^(?=.*[\\d])(?=.*[a-z])[\\w!@#$%^&*()-=+,.;:]{8,}$")) {
                    errors.add(new InputError("password", "Password require minimum eight characters, at least one letter and one number"));
                }
            }
        }

        LocalDate birthday = studentDTO.getBirthday();
        if (birthday == null) {
            errors.add(new InputError("birthday", "Birthday is required"));
        }

        int courseId = studentDTO.getCourseId();
        if (courseId == 0) {
            errors.add(new InputError("courseId", "Course is required"));
        }

        if (!errors.isEmpty()) {
            throw new InvalidFormException(errors);
        }
    }

    public static void validateUpdate(StudentDTO studentDTO) {

        List<InputError> errors = new ArrayList<>();

        int id = studentDTO.getId();
        if(id == 0) {
            errors.add(new InputError("id", "Id is required"));
        }
        validateCreate(studentDTO, errors);
    }

    public static void validateProfile(StudentProfileDTO studentProfileDTO) {

        List<InputError> errors = new ArrayList<>();

        String name = studentProfileDTO.getName();
        if (name == null || name.isEmpty()) {
            errors.add(new InputError("name","Name is required"));
        }

        String email = studentProfileDTO.getEmail();
        if (email == null || email.isEmpty()) {
            errors.add(new InputError("email", "Email is required"));
        }

        if (!email.matches("^\\S+@\\S+$")) {
            errors.add(new InputError("email", "Invalid email address"));
        }

        String password = studentProfileDTO.getPassword();
        if (password == null || password.isEmpty()) {
            errors.add(new InputError("password", "Password is required"));
        }

        if (!password.matches("[\\$\\S+\\$\\S+\\$\\S+]{60}")) {
            if (!password.matches("^(?=.*[\\d])(?=.*[a-z])[\\w!@#$%^&*()-=+,.;:]{8,}$")) {
                errors.add(new InputError("password", "Password require minimum eight characters, at least one letter and one number"));
            }
        }

        String newPassword = studentProfileDTO.getNewPassword();
        if (newPassword != null && !newPassword.isEmpty()) {
            if (!password.matches("^(?=.*[\\d])(?=.*[a-z])[\\w!@#$%^&*()-=+,.;:]{8,}$")) {
                errors.add(new InputError("newPassword", "Password require minimum eight characters, at least one letter and one number"));
            }
        }

        LocalDate birthday = studentProfileDTO.getBirthday();
        if (birthday == null) {
            errors.add(new InputError("birthday", "Birthday is required"));
        }

        if (!errors.isEmpty()) {
            throw new InvalidFormException(errors);
        }
    }
}
