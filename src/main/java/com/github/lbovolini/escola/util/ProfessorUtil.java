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
}
