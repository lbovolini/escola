package com.github.lbovolini.escola.util;

import com.github.lbovolini.escola.dto.TurmaDTO;
import com.github.lbovolini.escola.model.Turma;

public class TurmaUtil {

    public static TurmaDTO toDTO(Turma turma) {
        TurmaDTO turmaDTO = new TurmaDTO();
        turmaDTO.setId(turma.getId());
        turmaDTO.setNumber(turma.getNumber());
        turmaDTO.setCursoDTO(CursoUtil.toDTO(turma.getCurso()));

        return turmaDTO;
    }

    public static Turma toModel(TurmaDTO turmaDTO) {
        Turma turma = new Turma();
        turma.setId(turmaDTO.getId());
        turma.setNumber(turmaDTO.getNumber());
        turma.setCurso(CursoUtil.toModel(turmaDTO.getCursoDTO()));

        return turma;
    }
}
