package com.github.lbovolini.escola.service;

import com.github.lbovolini.escola.dto.CursoDTO;
import com.github.lbovolini.escola.dto.GradeCurricularDTO;
import com.github.lbovolini.escola.repository.CursoRepository;

import javax.inject.Inject;
import java.util.List;

public class CursoService {

    private final CursoRepository cursoRepository;

    @Inject
    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public void delete(int id) {
        cursoRepository.delete(id);
    }

    public CursoDTO find(int id) {
        return cursoRepository.find(id);
    }

    public List<CursoDTO> findAll() {
        return cursoRepository.findAll();
    }

    public List<GradeCurricularDTO> findGrandesCurriculares(int id) {
        return cursoRepository.findGrandesCurriculares(id);
    }

    public void save(CursoDTO cursoDto) {
        cursoRepository.save(cursoDto);
    }

    public void update(CursoDTO cursoDto) {
        cursoRepository.update(cursoDto);
    }
}
