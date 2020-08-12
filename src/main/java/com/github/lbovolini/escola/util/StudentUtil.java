package com.github.lbovolini.escola.util;

import com.github.lbovolini.escola.dto.StudentDTO;
import com.github.lbovolini.escola.dto.StudentProfileDTO;
import com.github.lbovolini.escola.dto.UserDTO;
import com.github.lbovolini.escola.model.Student;

import java.time.LocalDate;

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

    public static UserDTO toUsuarioDTO(StudentDTO studentDTO, String role, String token) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(studentDTO.getId());
        userDTO.setName(studentDTO.getName());
        userDTO.setEmail(studentDTO.getEmail());
        userDTO.setRole(role);
        userDTO.setToken(token);

        return userDTO;
    }

    public static void validate(StudentDTO studentDTO) {

        String name = studentDTO.getName();
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name is required");
        }

        String email = studentDTO.getEmail();
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email is required");
        }

        if (!email.matches("^\\S+@\\S+$")) {
            throw new IllegalArgumentException("Invalid email address");
        }

        String password = studentDTO.getPassword();
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password is required");
        }

        if (!password.matches("[\\$\\S+\\$\\S+\\$\\S+]{60}")) {
            if (!password.matches("^(?=.*[\\d])(?=.*[a-z])[\\w!@#$%^&*()-=+,.;:]{8,}$")) {
                throw new IllegalArgumentException("Password require minimum eight characters, at least one letter and one number");
            }
        }

        LocalDate birthday = studentDTO.getBirthday();
        if (birthday == null) {
            throw new IllegalArgumentException("Birthday is required");
        }

        int courseId = studentDTO.getCourseId();
        if (courseId == 0) {
            throw new IllegalArgumentException("Course is required");
        }
    }

    public static void validateAll(StudentDTO studentDTO) {

        int id = studentDTO.getId();
        if(id == 0) {
            throw new IllegalArgumentException("Id is required");
        }
        validate(studentDTO);
    }

    public static void validateProfile(StudentProfileDTO studentProfileDTO) {

        String name = studentProfileDTO.getName();
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name is required");
        }

        String email = studentProfileDTO.getEmail();
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email is required");
        }

        if (!email.matches("^\\S+@\\S+$")) {
            throw new IllegalArgumentException("Invalid email address");
        }

        String password = studentProfileDTO.getPassword();
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password is required");
        }

        if (!password.matches("[\\$\\S+\\$\\S+\\$\\S+]{60}")) {
            if (!password.matches("^(?=.*[\\d])(?=.*[a-z])[\\w!@#$%^&*()-=+,.;:]{8,}$")) {
                throw new IllegalArgumentException("Password require minimum eight characters, at least one letter and one number");
            }
        }

        String newPassword = studentProfileDTO.getNewPassword();
        if (newPassword != null && !newPassword.isEmpty()) {
            if (!password.matches("^(?=.*[\\d])(?=.*[a-z])[\\w!@#$%^&*()-=+,.;:]{8,}$")) {
                throw new IllegalArgumentException("Password require minimum eight characters, at least one letter and one number");
            }
        }

        LocalDate birthday = studentProfileDTO.getBirthday();
        if (birthday == null) {
            throw new IllegalArgumentException("Birthday is required");
        }
    }

}
