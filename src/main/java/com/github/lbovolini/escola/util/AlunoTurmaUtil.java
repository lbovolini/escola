package com.github.lbovolini.escola.util;

import com.github.lbovolini.escola.dto.AlunoDTO;
import com.github.lbovolini.escola.dto.AlunoTurmaDTO;
import com.github.lbovolini.escola.dto.TurmaDTO;
import com.github.lbovolini.escola.model.AlunoTurma;
import com.github.lbovolini.escola.model.AlunoTurmaId;

public class AlunoTurmaUtil {

    public static AlunoTurmaDTO toDTO(AlunoTurma alunoTurma) {
        AlunoTurmaDTO alunoTurmaDTO = new AlunoTurmaDTO();
        alunoTurmaDTO.setAlunoDTO(new AlunoDTO(alunoTurma.getAluno().getId()));
        alunoTurmaDTO.setTurmaDTO(new TurmaDTO(alunoTurma.getTurma().getId()));

        return alunoTurmaDTO;
    }

    public static AlunoTurma toModel(AlunoTurmaDTO alunoTurmaDTO) {
        AlunoTurmaId alunoTurmaId = new AlunoTurmaId();
        alunoTurmaId.setAlunoId(alunoTurmaDTO.getAlunoDTO().getId());
        alunoTurmaId.setTurmaId(alunoTurmaDTO.getTurmaDTO().getId());

        AlunoTurma alunoTurma = new AlunoTurma();
        alunoTurma.setAlunoTurmaId(alunoTurmaId);
        alunoTurma.setAluno(AlunoUtil.toModel(alunoTurmaDTO.getAlunoDTO()));
        alunoTurma.setTurma(TurmaUtil.toModel(alunoTurmaDTO.getTurmaDTO()));

        return alunoTurma;
    }
}
