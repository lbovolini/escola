package com.github.lbovolini.escola.dto;

import java.util.Objects;

public class CursoDTO {

    private int id;
    private String name;

    public CursoDTO() {
    }

    public CursoDTO(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CursoDTO cursoDTO = (CursoDTO) o;
        return id == cursoDTO.id &&
                Objects.equals(name, cursoDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
