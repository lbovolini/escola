package com.github.lbovolini.escola.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TeachId implements Serializable {

    @Column(name = "Disciplina_id")
    private int disciplineId;
    @Column(name = "Professor_id")
    private int teacherId;

    public int getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(int disciplineId) {
        this.disciplineId = disciplineId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeachId teachId = (TeachId) o;
        return disciplineId == teachId.disciplineId &&
                teacherId == teachId.teacherId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(disciplineId, teacherId);
    }
}
