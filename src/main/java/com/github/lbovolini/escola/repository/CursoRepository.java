package com.github.lbovolini.escola.repository;

import com.github.lbovolini.escola.dto.CursoDTO;

import java.util.List;

public interface CursoRepository {

    CursoDTO find(int id);

    List<CursoDTO> findAll();

    void save(CursoDTO cursoDTO);

    void delete(int id);

    void update(CursoDTO cursoDTO);
}
