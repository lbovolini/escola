package com.github.lbovolini.escola.util;

import com.github.lbovolini.escola.dto.AdministratorDTO;
import com.github.lbovolini.escola.dto.UserDTO;
import com.github.lbovolini.escola.model.Administrator;

public class AdministratorUtil {

    public static AdministratorDTO toDTO(Administrator administrator) {
        AdministratorDTO administratorDTO = new AdministratorDTO();
        administratorDTO.setId(administrator.getId());
        administratorDTO.setEmail(administrator.getEmail());
        administratorDTO.setPassword(administrator.getPassword());

        return administratorDTO;
    }

    public static UserDTO toUserDTO(AdministratorDTO administratorDTO, String role, String token) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(administratorDTO.getId());
        userDTO.setEmail(administratorDTO.getEmail());
        userDTO.setRole(role);
        userDTO.setToken(token);

        return userDTO;
    }
}
