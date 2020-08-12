package com.github.lbovolini.escola.util;

import com.github.lbovolini.escola.dto.TeacherDTO;
import com.github.lbovolini.escola.dto.UserDTO;
import com.github.lbovolini.escola.model.Teacher;

public class TeacherUtil {

    public static TeacherDTO toDTO(Teacher teacher) {
        TeacherDTO teacherDTO = new TeacherDTO();
        teacherDTO.setId(teacher.getId());
        teacherDTO.setName(teacher.getName());
        teacherDTO.setEmail(teacher.getEmail());
        teacherDTO.setPassword(teacher.getPassword());

        return teacherDTO;
    }

    public static Teacher toModel(TeacherDTO teacherDTO) {
        Teacher teacher = new Teacher();
        teacher.setId(teacherDTO.getId());
        teacher.setName(teacherDTO.getName());
        teacher.setEmail(teacherDTO.getEmail());
        teacher.setPassword(teacherDTO.getPassword());

        return teacher;
    }

    public static UserDTO toUsuarioDTO(TeacherDTO teacherDTO, String role, String token) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(teacherDTO.getId());
        userDTO.setName(teacherDTO.getName());
        userDTO.setEmail(teacherDTO.getEmail());
        userDTO.setRole(role);
        userDTO.setToken(token);

        return userDTO;
    }

    public static void validate(TeacherDTO teacherDTO) {

        String name = teacherDTO.getName();
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name is required");
        }

        String email = teacherDTO.getEmail();
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email is required");
        }

        if (!email.matches("^\\S+@\\S+$")) {
            throw new IllegalArgumentException("Invalid email address");
        }

        String password = teacherDTO.getPassword();
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password is required");
        }

        if (!password.matches("[\\$\\S+\\$\\S+\\$\\S+]{60}")) {
            if (!password.matches("^(?=.*[\\d])(?=.*[a-z])[\\w!@#$%^&*()-=+,.;:]{8,}$")) {
                throw new IllegalArgumentException("Password require minimum eight characters, at least one letter and one number");
            }
        }
    }

    public static void validateAll(TeacherDTO teacherDTO) {
        int id = teacherDTO.getId();
        if(id == 0) {
            throw new IllegalArgumentException("Id is required");
        }

        validate(teacherDTO);
    }
}
