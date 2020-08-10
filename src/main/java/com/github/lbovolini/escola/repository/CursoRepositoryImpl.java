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
    public List<CursoDTO> findAll() {

        String query = "Select c from Curso c";
        List<Curso> result = execute(query);

        List<CursoDTO> cursoDTOList = new ArrayList<>();

        for (Curso curso : result) {
            cursoDTOList.add(CursoUtil.toDTO(curso));
        }

        return cursoDTOList;
    }

    @Override
    public List<GradeCurricularDTO> findGrandesCurriculares(int id) {
        String query = "SELECT gc FROM GradeCurricular gc WHERE gc.curso = ?1";

        List parameters = new ArrayList();
        parameters.add(id);

        List<GradeCurricular> gradeCurricularList = execute(query, parameters);
        List<GradeCurricularDTO> gradeCurricularDTOList = gradeCurricularList.stream().map(GradeCurricularUtil::toDTO).collect(Collectors.toList());

        return gradeCurricularDTOList;
    }

    @Override
    public CursoDTO find(int id) {

        String query = "SELECT c FROM Curso c WHERE c.id = " + id;
        Curso curso = (Curso)executeSingle(query);

        return CursoUtil.toDTO(curso);
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM Curso c WHERE c.id = " + id;
        executeDelete(query);
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

    @Override
    public void save(CursoDTO cursoDTO) {
        Curso curso = CursoUtil.toModel(cursoDTO);
        super.save(curso);
    }
}
