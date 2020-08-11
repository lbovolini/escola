package com.github.lbovolini.escola.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String number;

    @ManyToOne
    @JoinColumn(name = "Curso_id", referencedColumnName = "id")
    private Curso curso;

    public Turma() {
    }

    public Turma(int id) {
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
        Turma turma = (Turma) o;
        return id == turma.id &&
                Objects.equals(number, turma.number) &&
                Objects.equals(curso, turma.curso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, curso);
    }
}
