package com.github.lbovolini.escola.util;

import com.github.lbovolini.escola.dto.AlunoDTO;
import com.github.lbovolini.escola.model.Aluno;

public class AlunoUtil {

    public static AlunoDTO toDTO(Aluno aluno) {
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setId(aluno.getId());
        alunoDTO.setName(aluno.getName());
        alunoDTO.setEmail(aluno.getEmail());
        alunoDTO.setPassword(aluno.getPassword());
        alunoDTO.setBirthday(aluno.getBirthday());
        alunoDTO.setCursoDTO(CursoUtil.toDTO(aluno.getCurso()));

        return alunoDTO;
    }

    public static Aluno toModel(AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno();
        aluno.setId(alunoDTO.getId());
        aluno.setName(alunoDTO.getName());
        aluno.setEmail(alunoDTO.getEmail());
        aluno.setPassword(alunoDTO.getPassword());
        aluno.setBirthday(alunoDTO.getBirthday());
        aluno.setCurso(CursoUtil.toModel(alunoDTO.getCursoDTO()));

        return aluno;
    }
}
