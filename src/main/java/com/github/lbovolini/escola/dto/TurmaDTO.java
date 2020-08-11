package com.github.lbovolini.escola.dto;

import java.util.Objects;

public class TurmaDTO {

    private int id;
    private String number;
    private CursoDTO cursoDTO;

    public TurmaDTO() {
    }

    public TurmaDTO(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public CursoDTO getCursoDTO() {
        return cursoDTO;
    }

    public void setCursoDTO(CursoDTO cursoDTO) {
        this.cursoDTO = cursoDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TurmaDTO turmaDTO = (TurmaDTO) o;
        return id == turmaDTO.id &&
                Objects.equals(number, turmaDTO.number) &&
                Objects.equals(cursoDTO, turmaDTO.cursoDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, cursoDTO);
    }
}
