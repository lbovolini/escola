package com.github.lbovolini.escola.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class GradeCurricular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int year;

    @ManyToOne
    @JoinColumn(name = "Curso_id", referencedColumnName = "id")
    private Curso curso;

    public GradeCurricular() {
    }

    public GradeCurricular(int id) {
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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GradeCurricular that = (GradeCurricular) o;
        return id == that.id &&
                year == that.year &&
                Objects.equals(curso, that.curso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, year, curso);
    }
}
