package com.github.lbovolini.escola.util;

import com.github.lbovolini.escola.dto.ProfessorDTO;
import com.github.lbovolini.escola.dto.UsuarioDTO;
import com.github.lbovolini.escola.model.Professor;

public class ProfessorUtil {

    public static ProfessorDTO toDTO(Professor professor) {
        ProfessorDTO professorDTO = new ProfessorDTO();
        professorDTO.setId(professor.getId());
        professorDTO.setName(professor.getName());
        professorDTO.setEmail(professor.getEmail());
        professorDTO.setPassword(professor.getPassword());

        return professorDTO;
    }

    public static Professor toModel(ProfessorDTO professorDTO) {
        Professor professor = new Professor();
        professor.setId(professorDTO.getId());
        professor.setName(professorDTO.getName());
        professor.setEmail(professorDTO.getEmail());
        professor.setPassword(professorDTO.getPassword());

        return professor;
    }

    public static UsuarioDTO toUsuarioDTO(ProfessorDTO professorDTO, String role, String token) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(professorDTO.getId());
        usuarioDTO.setName(professorDTO.getName());
        usuarioDTO.setEmail(professorDTO.getEmail());
        usuarioDTO.setRole(role);
        usuarioDTO.setToken(token);

        return usuarioDTO;
    }

    public static void validate(ProfessorDTO professorDTO) {

        String name = professorDTO.getName();
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name is required");
        }

        String email = professorDTO.getEmail();
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email is required");
        }

        if (!email.matches("^\\S+@\\S+$")) {
            throw new IllegalArgumentException("Invalid email address");
        }

        String password = professorDTO.getPassword();
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password is required");
        }

        if (!password.matches("[\\$\\S+\\$\\S+\\$\\S+]{60}")) {
            if (!password.matches("^(?=.*[\\d])(?=.*[a-z])[\\w!@#$%^&*()-=+,.;:]{8,}$")) {
                throw new IllegalArgumentException("Password require minimum eight characters, at least one letter and one number");
            }
        }
    }

    public static void validateAll(ProfessorDTO professorDTO) {
        int id = professorDTO.getId();
        if(id == 0) {
            throw new IllegalArgumentException("Id is required");
        }

        validate(professorDTO);
    }
}
