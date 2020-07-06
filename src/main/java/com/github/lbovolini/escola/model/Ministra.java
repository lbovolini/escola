package com.github.lbovolini.escola.model;

import javax.persistence.*;

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
}
