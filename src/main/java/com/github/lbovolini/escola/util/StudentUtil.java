package com.github.lbovolini.escola.util;

import com.github.lbovolini.escola.dto.StudentDTO;
import com.github.lbovolini.escola.dto.UserDTO;
import com.github.lbovolini.escola.model.Student;

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
}
