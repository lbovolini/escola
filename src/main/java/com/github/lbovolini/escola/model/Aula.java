package com.github.lbovolini.escola.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Aula {

    @EmbeddedId
    private AulaId aulaId;

    @ManyToOne
    @MapsId("Disciplina_id")
    @JoinColumn(name = "Disciplina_id")
    private Disciplina disciplina;

    @ManyToOne
    @MapsId("Turma_id")
    @JoinColumn(name = "Turma_id")
    private Turma turma;

    public AulaId getAulaId() {
        return aulaId;
    }

    public void setAulaId(AulaId aulaId) {
        this.aulaId = aulaId;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
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
        Aula aula = (Aula) o;
        return Objects.equals(aulaId, aula.aulaId) &&
                Objects.equals(disciplina, aula.disciplina) &&
                Objects.equals(turma, aula.turma);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aulaId, disciplina, turma);
    }
}
