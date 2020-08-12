package com.github.lbovolini.escola.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class DisciplinaGradeCurricular {

    @EmbeddedId
    private DisciplinaGradeCurricularId disciplinaGradeCurricularId;
    @Column(name = "Disciplina_id")
    private int disciplineId;
    @Column(name = "Gradecurricular_id")
    private int curriculumId;

    @ManyToOne
    @MapsId("Disciplina_id")
    @JoinColumn(name = "Disciplina_id", insertable = false, updatable = false)
    private Disciplina disciplina;

    @ManyToOne
    @MapsId("GradeCurricular_id")
    @JoinColumn(name = "GradeCurricular_id", insertable = false, updatable = false)
    private GradeCurricular gradeCurricular;

    public DisciplinaGradeCurricularId getDisciplinaGradeCurricularId() {
        return disciplinaGradeCurricularId;
    }

    public void setDisciplinaGradeCurricularId(DisciplinaGradeCurricularId disciplinaGradeCurricularId) {
        this.disciplinaGradeCurricularId = disciplinaGradeCurricularId;
    }

    public int getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(int disciplineId) {
        this.disciplineId = disciplineId;
    }

    public int getCurriculum() {
        return curriculumId;
    }

    public void setCurriculum(int curriculumId) {
        this.curriculumId = curriculumId;
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
        return disciplineId == that.disciplineId &&
                curriculumId == that.curriculumId &&
                Objects.equals(disciplinaGradeCurricularId, that.disciplinaGradeCurricularId) &&
                Objects.equals(disciplina, that.disciplina) &&
                Objects.equals(gradeCurricular, that.gradeCurricular);
    }

    @Override
    public int hashCode() {
        return Objects.hash(disciplinaGradeCurricularId, disciplineId, curriculumId, disciplina, gradeCurricular);
    }
}
