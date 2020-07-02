package com.github.lbovolini.escola.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String number;

    @ManyToOne
    @JoinColumn(name = "Curso_id", referencedColumnName = "id")
    private Curso curso;

    @OneToMany(mappedBy = "turma")
    private Set<AlunoTurma> alunoTurmas;

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

    public Set<AlunoTurma> getAlunoTurmas() {
        return alunoTurmas;
    }

    public void setAlunoTurmas(Set<AlunoTurma> alunoTurmas) {
        this.alunoTurmas = alunoTurmas;
    }
}
