package com.github.lbovolini.escola.repository;

import com.github.lbovolini.escola.dto.CursoDTO;
import com.github.lbovolini.escola.model.Curso;
import com.github.lbovolini.escola.util.CursoUtil;

import java.util.ArrayList;
import java.util.List;

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
