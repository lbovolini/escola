package com.github.lbovolini.escola.util;

import com.github.lbovolini.escola.dto.AulaDTO;
import com.github.lbovolini.escola.model.Aula;
import com.github.lbovolini.escola.model.AulaId;

public class AulaUtil {

    public static AulaDTO toDTO(Aula aula) {
        AulaDTO aulaDTO = new AulaDTO();
        aulaDTO.setAlunoId(aula.getAulaId().getAlunoId());
        aulaDTO.setTurmaId(aula.getAulaId().getTurmaId());
        aulaDTO.setDay(aula.getAulaId().getDay());

        return aulaDTO;
    }

    public static Aula toModel(AulaDTO aulaDTO) {
        AulaId aulaId = new AulaId();
        aulaId.setAlunoId(aulaDTO.getAlunoId());
        aulaId.setTurmaId(aulaDTO.getTurmaId());
        aulaId.setDay(aulaDTO.getDay());

        Aula aula = new Aula();
        aula.setAulaId(aulaId);

        return aula;
    }
}
