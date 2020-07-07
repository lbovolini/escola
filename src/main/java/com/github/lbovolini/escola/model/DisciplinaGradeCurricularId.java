package com.github.lbovolini.escola.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class DisciplinaGradeCurricularId implements Serializable {

    @Column(name = "Disciplina_id")
    private int disciplinaId;
    @Column(name = "GradeCurricular_id")
    private int gradeCurricularId;

    public int getDisciplinaId() {
        return disciplinaId;
    }

    public void setDisciplinaId(int disciplinaId) {
        this.disciplinaId = disciplinaId;
    }

    public int getGradeCurricularId() {
        return gradeCurricularId;
    }

    public void setGradeCurricularId(int gradeCurricularId) {
        this.gradeCurricularId = gradeCurricularId;
    }
}
