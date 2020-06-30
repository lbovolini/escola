package com.github.lbovolini.escola.model;

import javax.persistence.*;

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
}
