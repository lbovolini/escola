package com.github.lbovolini.escola.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public Curso() {}

    public Curso(int id) {
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
        Curso curso = (Curso) o;
        return id == curso.id &&
                Objects.equals(name, curso.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
