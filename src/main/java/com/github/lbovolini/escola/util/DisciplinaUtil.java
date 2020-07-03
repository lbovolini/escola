package com.github.lbovolini.escola.util;

import com.github.lbovolini.escola.dto.DisciplinaDTO;
import com.github.lbovolini.escola.model.Disciplina;

public class DisciplinaUtil {

    public static DisciplinaDTO toDTO(Disciplina disciplina) {
        DisciplinaDTO disciplinaDTO = new DisciplinaDTO();
        disciplinaDTO.setId(disciplina.getId());
        disciplinaDTO.setName(disciplina.getName());

        return disciplinaDTO;
    }

    public static Disciplina toModel(DisciplinaDTO disciplinaDTO) {
        Disciplina disciplina = new Disciplina();
        disciplina.setId(disciplinaDTO.getId());
        disciplina.setName(disciplinaDTO.getName());

        return disciplina;
    }
}
