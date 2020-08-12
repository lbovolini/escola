package com.github.lbovolini.escola.util;

import com.github.lbovolini.escola.dto.DisciplineDTO;
import com.github.lbovolini.escola.model.Discipline;

public class DisciplineUtil {

    public static DisciplineDTO toDTO(Discipline discipline) {
        DisciplineDTO disciplineDTO = new DisciplineDTO();
        disciplineDTO.setId(discipline.getId());
        disciplineDTO.setName(discipline.getName());

        return disciplineDTO;
    }

    public static Discipline toModel(DisciplineDTO disciplineDTO) {
        Discipline discipline = new Discipline();
        discipline.setId(disciplineDTO.getId());
        discipline.setName(disciplineDTO.getName());

        return discipline;
    }
}
