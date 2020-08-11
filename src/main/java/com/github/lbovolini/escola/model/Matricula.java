package com.github.lbovolini.escola.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Matricula {

    @EmbeddedId
    private MatriculaId matriculaId;

    @ManyToOne
    @MapsId("Aluno_id")
    @JoinColumn(name = "Aluno_id")
    private Aluno aluno;

    @ManyToOne
    @MapsId("Disciplina_id")
    @JoinColumn(name = "Disciplina_id")
    private Disciplina disciplina;

    public MatriculaId getMatriculaId() {
        return matriculaId;
    }

    public void setMatriculaId(MatriculaId matriculaId) {
        this.matriculaId = matriculaId;
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
        return Objects.equals(matriculaId, matricula.matriculaId) &&
                Objects.equals(aluno, matricula.aluno) &&
                Objects.equals(disciplina, matricula.disciplina);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matriculaId, aluno, disciplina);
    }
}
