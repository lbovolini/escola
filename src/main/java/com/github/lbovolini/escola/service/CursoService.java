package com.github.lbovolini.escola.service;

import com.github.lbovolini.escola.dto.CursoDTO;
import com.github.lbovolini.escola.model.Curso;
import com.github.lbovolini.escola.repository.CursoRepository;
import com.github.lbovolini.escola.repository.CursoRepositoryImpl;

import java.util.List;

public class CursoService {

    private CursoRepository cursoRepository;

    public CursoService() {
        this.cursoRepository = new CursoRepositoryImpl();
    }

    public Curso find(int id) {
        return cursoRepository.find(id);
    }

    public void save(CursoDTO cursoDto) {

        Curso curso = new Curso();
        curso.setId(cursoDto.id);
        curso.setName(cursoDto.name);

        cursoRepository.save(curso);
    }

    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }


    public void delete(int id) {
        cursoRepository.delete(id);
    }

    public void update(CursoDTO cursoDto) {

        Curso curso = new Curso();
        curso.setId(cursoDto.id);
        curso.setName(cursoDto.name);

        cursoRepository.update(curso);
    }
}
