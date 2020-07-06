package com.github.lbovolini.escola.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MinistraId implements Serializable {

    @Column(name = "Disciplina_id")
    private int disciplinaId;
    @Column(name = "Professor_id")
    private int professorId;

    public int getDisciplinaId() {
        return disciplinaId;
    }

    public void setDisciplinaId(int disciplinaId) {
        this.disciplinaId = disciplinaId;
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }
}
