package com.github.lbovolini.escola.repository;

import com.github.lbovolini.escola.dto.CursoDTO;
import com.github.lbovolini.escola.dto.GradeCurricularDTO;
import com.github.lbovolini.escola.model.Curso;
import com.github.lbovolini.escola.model.GradeCurricular;
import com.github.lbovolini.escola.util.CursoUtil;
import com.github.lbovolini.escola.util.GradeCurricularUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CursoRepositoryImpl extends RepositoryBase<Curso> implements CursoRepository {

    @Override
    public void delete(int id) {
        String query = "DELETE FROM Curso c WHERE c.id = ?1";

        List parameters = new ArrayList();
        parameters.add(id);

        executeDelete(query, parameters);
    }

    @Override
    public CursoDTO find(int id) {

        String query = "SELECT c FROM Curso c WHERE c.id = ?1";

        List parameters = new ArrayList();
        parameters.add(id);

        Curso curso = (Curso)executeSingle(query, parameters);

        return CursoUtil.toDTO(curso);
    }

    @Override
    public List<CursoDTO> findAll() {

        String query = "SELECT c FROM Curso c";
        List<Curso> cursoList = execute(query);

        List<CursoDTO> cursoDTOList = cursoList.stream().map(CursoUtil::toDTO).collect(Collectors.toList());

        return cursoDTOList;
    }

    @Override
    public List<GradeCurricularDTO> findGrandesCurriculares(int id) {
        String query = "SELECT gc FROM GradeCurricular gc WHERE gc.curso = ?1";

        List parameters = new ArrayList();
        parameters.add(new Curso(id));

        List<GradeCurricular> gradeCurricularList = execute(query, parameters);
        List<GradeCurricularDTO> gradeCurricularDTOList = gradeCurricularList.stream().map(GradeCurricularUtil::toDTO).collect(Collectors.toList());

        return gradeCurricularDTOList;
    }

    @Override
    public void save(CursoDTO cursoDTO) {
        Curso curso = CursoUtil.toModel(cursoDTO);
        super.save(curso);
    }

    @Override
    public void update(CursoDTO cursoDTO) {

        CursoDTO cursoDTO1 = find(cursoDTO.getId());

        if (cursoDTO1 == null) {
            return;
        }

        Curso curso = CursoUtil.toModel(cursoDTO);
        super.update(curso);
    }
}
