package com.github.lbovolini.escola.dto;

import java.util.Date;

public class AulaDTO {

    private int alunoId;
    private int turmaId;
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
