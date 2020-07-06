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
    @Column(name = "Disciplina_id")
    private int disciplinaId;
    @Column(name = "day")
    @Temporal(TemporalType.DATE)
    private Date day;

    public int getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(int alunoId) {
        this.alunoId = alunoId;
    }

    public int getDisciplinaId() {
        return disciplinaId;
    }

    public void setDisciplinaId(int disciplinaId) {
        this.disciplinaId = disciplinaId;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }
}
