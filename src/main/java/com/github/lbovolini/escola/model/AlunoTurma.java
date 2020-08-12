package com.github.lbovolini.escola.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class AlunoTurma {

    @EmbeddedId
    private AlunoTurmaId alunoTurmaId;
    @Column(name = "Aluno_id")
    private int studentId;
    @Column(name = "Turma_id")
    private int groupId;

    @ManyToOne
    @MapsId("Aluno_id")
    @JoinColumn(name = "Aluno_id", insertable = false, updatable = false)
    private Aluno aluno;

    @ManyToOne
    @MapsId("Turma_id")
    @JoinColumn(name = "Turma_id", insertable = false, updatable = false)
    private Turma turma;

    public AlunoTurmaId getAlunoTurmaId() {
        return alunoTurmaId;
    }

    public void setAlunoTurmaId(AlunoTurmaId alunoTurmaId) {
        this.alunoTurmaId = alunoTurmaId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlunoTurma that = (AlunoTurma) o;
        return studentId == that.studentId &&
                groupId == that.groupId &&
                Objects.equals(alunoTurmaId, that.alunoTurmaId) &&
                Objects.equals(aluno, that.aluno) &&
                Objects.equals(turma, that.turma);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alunoTurmaId, studentId, groupId, aluno, turma);
    }
}
