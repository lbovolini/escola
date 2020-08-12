package com.github.lbovolini.escola.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Matricula {

    @EmbeddedId
    private MatriculaId matriculaId;
    @Column(name = "Aluno_id")
    private int studentId;
    @Column(name = "Disciplina_id")
    private int disciplineId;

    @ManyToOne
    @MapsId("Aluno_id")
    @JoinColumn(name = "Aluno_id", insertable = false, updatable = false)
    private Aluno aluno;

    @ManyToOne
    @MapsId("Disciplina_id")
    @JoinColumn(name = "Disciplina_id", insertable = false, updatable = false)
    private Disciplina disciplina;

    public MatriculaId getMatriculaId() {
        return matriculaId;
    }

    public void setMatriculaId(MatriculaId matriculaId) {
        this.matriculaId = matriculaId;
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

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matricula matricula = (Matricula) o;
        return studentId == matricula.studentId &&
                disciplineId == matricula.disciplineId &&
                Objects.equals(matriculaId, matricula.matriculaId) &&
                Objects.equals(aluno, matricula.aluno) &&
                Objects.equals(disciplina, matricula.disciplina);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matriculaId, studentId, disciplineId, aluno, disciplina);
    }
}
