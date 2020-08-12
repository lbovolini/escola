package com.github.lbovolini.escola.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EnrollmentId implements Serializable {

    @Column(name = "Aluno_id")
    private int studentId;
    @Column(name = "Disciplina_id")
    private int disciplineId;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(int disciplineId) {
        this.disciplineId = disciplineId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnrollmentId that = (EnrollmentId) o;
        return studentId == that.studentId &&
                disciplineId == that.disciplineId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, disciplineId);
    }
}
