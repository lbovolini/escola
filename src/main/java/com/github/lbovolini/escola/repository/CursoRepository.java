package com.github.lbovolini.escola.repository;

import com.github.lbovolini.escola.dto.CursoDTO;
import com.github.lbovolini.escola.dto.GradeCurricularDTO;

import java.util.List;

public interface CursoRepository {

    void delete(int id);

    CursoDTO find(int id);

    List<CursoDTO> findAll();

    List<GradeCurricularDTO> findGrandesCurriculares(int id);

    void save(CursoDTO cursoDTO);

    void update(CursoDTO cursoDTO);
}
