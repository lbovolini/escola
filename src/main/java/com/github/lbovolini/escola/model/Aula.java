package com.github.lbovolini.escola.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Aula {

    @EmbeddedId
    private AulaId aulaId;

    @ManyToOne
    @MapsId("Aluno_id")
    @JoinColumn(name = "Aluno_id")
    private Aluno aluno;

    @ManyToOne
    @MapsId("Disciplina_id")
    @JoinColumn(name = "Disciplina_id")
    private Disciplina disciplina;

    @MapsId("day")
    private Date day;

    public AulaId getAulaId() {
        return aulaId;
    }

    public void setAulaId(AulaId aulaId) {
        this.aulaId = aulaId;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }
}
