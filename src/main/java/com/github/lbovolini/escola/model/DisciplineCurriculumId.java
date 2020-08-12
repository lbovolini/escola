package com.github.lbovolini.escola.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DisciplineCurriculumId implements Serializable {

    @Column(name = "Disciplina_id")
    private int disciplineId;
    @Column(name = "GradeCurricular_id")
    private int curriculumId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisciplineCurriculumId that = (DisciplineCurriculumId) o;
        return disciplineId == that.disciplineId &&
                curriculumId == that.curriculumId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(disciplineId, curriculumId);
    }
}
