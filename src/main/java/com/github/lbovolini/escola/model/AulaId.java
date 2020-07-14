package com.github.lbovolini.escola.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class AulaId implements Serializable {

    @Column(name = "Aluno_id")
    private int alunoId;
    @Column(name = "Turma_id")
    private int turmaId;
    @Column(name = "day")
    @Temporal(TemporalType.DATE)
    private Date day;

    public int getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(int alunoId) {
        this.alunoId = alunoId;
    }

    public int getTurmaId() {
        return turmaId;
    }

    public void setTurmaId(int turmaId) {
        this.turmaId = turmaId;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }
}
