package com.github.lbovolini.escola.util;

import com.github.lbovolini.escola.dto.TeacherDTO;
import com.github.lbovolini.escola.dto.UserDTO;

public class TeacherUtil {

    public static UserDTO toUserDTO(TeacherDTO teacherDTO, String role, String token) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(teacherDTO.getId());
        userDTO.setName(teacherDTO.getName());
        userDTO.setEmail(teacherDTO.getEmail());
        userDTO.setRole(role);
        userDTO.setToken(token);

        return userDTO;
    }
}
