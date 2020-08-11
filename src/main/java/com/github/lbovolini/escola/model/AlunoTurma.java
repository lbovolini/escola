package com.github.lbovolini.escola.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class AlunoTurma {

    @EmbeddedId
    private AlunoTurmaId alunoTurmaId;

    @ManyToOne
    @MapsId("Aluno_id")
    @JoinColumn(name = "Aluno_id")
    private Aluno aluno;

    @ManyToOne
    @MapsId("Turma_id")
    @JoinColumn(name = "Turma_id")
    private Turma turma;

    public AlunoTurmaId getAlunoTurmaId() {
        return alunoTurmaId;
    }

    public void setAlunoTurmaId(AlunoTurmaId alunoTurmaId) {
        this.alunoTurmaId = alunoTurmaId;
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
        return Objects.equals(alunoTurmaId, that.alunoTurmaId) &&
                Objects.equals(aluno, that.aluno) &&
                Objects.equals(turma, that.turma);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alunoTurmaId, aluno, turma);
    }
}
