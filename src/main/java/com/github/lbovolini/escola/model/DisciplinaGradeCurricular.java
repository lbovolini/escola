package com.github.lbovolini.escola.model;

import javax.persistence.*;

@Entity
public class DisciplinaGradeCurricular {

    @EmbeddedId
    private DisciplinaGradeCurricularId disciplinaGradeCurricularId;

    @ManyToOne
    @MapsId("Disciplina_id")
    @JoinColumn(name = "Disciplina_id")
    private Disciplina disciplina;

    @ManyToOne
    @MapsId("GradeCurricular_id")
    @JoinColumn(name = "GradeCurricular_id")
    private GradeCurricular gradeCurricular;

    public DisciplinaGradeCurricularId getDisciplinaGradeCurricularId() {
        return disciplinaGradeCurricularId;
    }

    public void setDisciplinaGradeCurricularId(DisciplinaGradeCurricularId disciplinaGradeCurricularId) {
        this.disciplinaGradeCurricularId = disciplinaGradeCurricularId;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public GradeCurricular getGradeCurricular() {
        return gradeCurricular;
    }

    public void setGradeCurricular(GradeCurricular gradeCurricular) {
        this.gradeCurricular = gradeCurricular;
    }
}
