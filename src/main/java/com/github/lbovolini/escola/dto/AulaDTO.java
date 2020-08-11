package com.github.lbovolini.escola.dto;

import java.util.Date;
import java.util.Objects;

public class AulaDTO {

    private int disciplinaId;
    private int turmaId;
    private Date day;

    public int getDisciplinaId() {
        return disciplinaId;
    }

    public void setDisciplinaId(int disciplinaId) {
        this.disciplinaId = disciplinaId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AulaDTO aulaDTO = (AulaDTO) o;
        return disciplinaId == aulaDTO.disciplinaId &&
                turmaId == aulaDTO.turmaId &&
                Objects.equals(day, aulaDTO.day);
    }

    @Override
    public int hashCode() {
        return Objects.hash(disciplinaId, turmaId, day);
    }
}
