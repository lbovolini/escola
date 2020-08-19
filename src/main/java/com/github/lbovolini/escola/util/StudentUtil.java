package com.github.lbovolini.escola.util;

import com.github.lbovolini.escola.dto.StudentDTO;
import com.github.lbovolini.escola.dto.UserDTO;

public class StudentUtil {

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
