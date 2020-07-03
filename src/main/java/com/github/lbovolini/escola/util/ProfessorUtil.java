package com.github.lbovolini.escola.util;

import com.github.lbovolini.escola.dto.ProfessorDTO;
import com.github.lbovolini.escola.model.Professor;

public class ProfessorUtil {

    public static ProfessorDTO toDTO(Professor professor) {
        ProfessorDTO professorDTO = new ProfessorDTO();
        professorDTO.setId(professor.getId());
        professorDTO.setName(professor.getName());

        return professorDTO;
    }

    public static Professor toModel(ProfessorDTO professorDTO) {
        Professor professor = new Professor();
        professor.setId(professorDTO.getId());
        professor.setName(professorDTO.getName());

        return professor;
    }
}