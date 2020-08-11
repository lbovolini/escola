package com.github.lbovolini.escola.model;

import javax.persistence.*;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisciplinaGradeCurricular that = (DisciplinaGradeCurricular) o;
        return Objects.equals(disciplinaGradeCurricularId, that.disciplinaGradeCurricularId) &&
                Objects.equals(disciplina, that.disciplina) &&
                Objects.equals(gradeCurricular, that.gradeCurricular);
    }

    @Override
    public int hashCode() {
        return Objects.hash(disciplinaGradeCurricularId, disciplina, gradeCurricular);
    }
}
