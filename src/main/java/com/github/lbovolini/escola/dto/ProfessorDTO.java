package com.github.lbovolini.escola.dto;

public class ProfessorDTO {

    private int id;
    private String name;

    public ProfessorDTO() {
    }

    public ProfessorDTO(int id) {
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
}
