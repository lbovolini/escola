package com.github.lbovolini.escola.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Ministra {

    @EmbeddedId
    private MinistraId ministraId;

    @ManyToOne
    @MapsId("Disciplina_id")
    @JoinColumn(name = "Disciplina_id")
    private Disciplina disciplina;

    @ManyToOne
    @MapsId("Professor_id")
    @JoinColumn(name = "Professor_id")
    private Professor professor;

    public MinistraId getMinistraId() {
        return ministraId;
    }

    public void setMinistraId(MinistraId ministraId) {
        this.ministraId = ministraId;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ministra ministra = (Ministra) o;
        return Objects.equals(ministraId, ministra.ministraId) &&
                Objects.equals(disciplina, ministra.disciplina) &&
                Objects.equals(professor, ministra.professor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ministraId, disciplina, professor);
    }
}
