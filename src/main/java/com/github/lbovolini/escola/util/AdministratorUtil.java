package com.github.lbovolini.escola.util;

import com.github.lbovolini.escola.dto.AdministratorDTO;
import com.github.lbovolini.escola.dto.UserDTO;

public class AdministratorUtil {

    public static UserDTO toUserDTO(AdministratorDTO administratorDTO, String role, String token) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(administratorDTO.getId());
        userDTO.setEmail(administratorDTO.getEmail());
        userDTO.setRole(role);
        userDTO.setToken(token);

        return userDTO;
    }
}
