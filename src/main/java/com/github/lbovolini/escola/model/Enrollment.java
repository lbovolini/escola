package com.github.lbovolini.escola.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Matricula")
public class Enrollment {

    @EmbeddedId
    private EnrollmentId enrollmentId;
    @Column(name = "Aluno_id", insertable = false, updatable = false)
    private int studentId;
    @Column(name = "Disciplina_id", insertable = false, updatable = false)
    private int disciplineId;

    @ManyToOne
    @MapsId("Aluno_id")
    @JoinColumn(name = "Aluno_id", insertable = false, updatable = false)
    private Student student;

    @ManyToOne
    @MapsId("Disciplina_id")
    @JoinColumn(name = "Disciplina_id", insertable = false, updatable = false)
    private Discipline discipline;

    public EnrollmentId getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(EnrollmentId enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enrollment enrollment = (Enrollment) o;
        return studentId == enrollment.studentId &&
                disciplineId == enrollment.disciplineId &&
                Objects.equals(enrollmentId, enrollment.enrollmentId) &&
                Objects.equals(student, enrollment.student) &&
                Objects.equals(discipline, enrollment.discipline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enrollmentId, studentId, disciplineId, student, discipline);
    }
}
