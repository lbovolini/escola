package com.github.lbovolini.escola.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "DisciplinaGradeCurricular")
public class DisciplineCurriculum {

    @EmbeddedId
    private DisciplineCurriculumId disciplineCurriculumId;
    @Column(name = "Disciplina_id", insertable = false, updatable = false)
    private int disciplineId;
    @Column(name = "GradeCurricular_id", insertable = false, updatable = false)
    private int curriculumId;

    @ManyToOne
    @MapsId("Disciplina_id")
    @JoinColumn(name = "Disciplina_id", insertable = false, updatable = false)
    private Discipline discipline;

    @ManyToOne
    @MapsId("GradeCurricular_id")
    @JoinColumn(name = "GradeCurricular_id", insertable = false, updatable = false)
    private Curriculum curriculum;

    public DisciplineCurriculumId getDisciplineCurriculumId() {
        return disciplineCurriculumId;
    }

    public void setDisciplineCurriculumId(DisciplineCurriculumId disciplineCurriculumId) {
        this.disciplineCurriculumId = disciplineCurriculumId;
    }

    public int getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(int disciplineId) {
        this.disciplineId = disciplineId;
    }

    public int getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(int curriculumId) {
        this.curriculumId = curriculumId;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisciplineCurriculum that = (DisciplineCurriculum) o;
        return disciplineId == that.disciplineId &&
                curriculumId == that.curriculumId &&
                Objects.equals(disciplineCurriculumId, that.disciplineCurriculumId) &&
                Objects.equals(discipline, that.discipline) &&
                Objects.equals(curriculum, that.curriculum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(disciplineCurriculumId, disciplineId, curriculumId, discipline, curriculum);
    }
}
