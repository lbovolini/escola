package com.github.lbovolini.escola.dto;

public class GradeCurricularDTO {

    private int id;
    private int year;
    private CursoDTO cursoDTO;

    public GradeCurricularDTO() {
    }

    public GradeCurricularDTO(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public CursoDTO getCursoDTO() {
        return cursoDTO;
    }

    public void setCursoDTO(CursoDTO cursoDTO) {
        this.cursoDTO = cursoDTO;
    }
}
