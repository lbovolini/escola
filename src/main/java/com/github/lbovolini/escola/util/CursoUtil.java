package com.github.lbovolini.escola.util;

import com.github.lbovolini.escola.dto.CursoDTO;
import com.github.lbovolini.escola.model.Curso;
import com.github.lbovolini.escola.model.GradeCurricular;

public class CursoUtil {

    public static CursoDTO toDTO(Curso curso) {
        CursoDTO cursoDTO = new CursoDTO();
        cursoDTO.setId(curso.getId());
        cursoDTO.setName(curso.getName());

        return cursoDTO;
    }

    public static Curso toModel(CursoDTO cursoDTO) {
        Curso curso = new Curso();
        curso.setId(cursoDTO.getId());
        curso.setName(cursoDTO.getName());

        return curso;
    }
}
