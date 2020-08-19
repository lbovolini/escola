package com.github.lbovolini.escola.util;

import com.github.lbovolini.escola.auth.Role;
import com.github.lbovolini.escola.dto.AdministratorDTO;
import com.github.lbovolini.escola.dto.UserDTO;
import com.github.lbovolini.escola.model.Administrator;
import org.junit.jupiter.api.Test;

import javax.persistence.JoinColumn;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class AdministratorUtilTest {

    private final int id = 1;
    private final String email = "admin@admin";
    private final String password = "password";
    private final String role = Role.administrator();
    private final String token = "token";

    @Test
    void shouldConvertAllAttributes() {

        Field[] administratorAttributes = Administrator.class.getDeclaredFields();

        int administratorAttributesSize = 0;
        for (Field attribute: administratorAttributes) {
            if (attribute.getDeclaredAnnotation(JoinColumn.class) == null) {
                administratorAttributesSize++;
            }
        }

        Field[] administratorDTOAttributes = AdministratorDTO.class.getDeclaredFields();

        int administratorDTOAttributesSize = 0;
        for (Field attribute: administratorDTOAttributes) {
            administratorDTOAttributesSize++;
        }

        assertEquals(administratorAttributesSize, administratorDTOAttributesSize);
    }

    @Test
    void shouldConvertAdministratorDTOToUserDTO() {
        AdministratorDTO administratorDTO = new AdministratorDTO();
        administratorDTO.setId(id);
        administratorDTO.setEmail(email);
        administratorDTO.setPassword(password);

        UserDTO userDTO = AdministratorUtil.toUserDTO(administratorDTO, role, token);

        assertEquals(id, userDTO.getId());
        assertEquals(email, userDTO.getEmail());
        assertEquals(role, userDTO.getRole());
        assertEquals(token, userDTO.getToken());
    }
}