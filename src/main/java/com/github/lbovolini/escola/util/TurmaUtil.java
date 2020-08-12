package com.github.lbovolini.escola.util;

import com.github.lbovolini.escola.dto.TurmaDTO;
import com.github.lbovolini.escola.model.Turma;

public class TurmaUtil {

    public static TurmaDTO toDTO(Turma turma) {
        TurmaDTO turmaDTO = new TurmaDTO();
        turmaDTO.setId(turma.getId());
        turmaDTO.setNumber(turma.getNumber());
        turmaDTO.setCourseId(turma.getCourseId());

        return turmaDTO;
    }

    public static Turma toModel(TurmaDTO turmaDTO) {
        Turma turma = new Turma();
        turma.setId(turmaDTO.getId());
        turma.setNumber(turmaDTO.getNumber());
        turma.setCourseId(turmaDTO.getCourseId());

        return turma;
    }
}
