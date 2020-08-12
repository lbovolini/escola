package com.github.lbovolini.escola.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Ministra")
public class Teach {

    @EmbeddedId
    private TeachId teachId;
    @Column(name = "Disciplina_id", insertable = false, updatable = false)
    private int disciplineId;
    @Column(name = "Professor_id", insertable = false, updatable = false)
    private int teacherId;

    @ManyToOne
    @MapsId("Disciplina_id")
    @JoinColumn(name = "Disciplina_id", insertable = false, updatable = false)
    private Discipline discipline;

    @ManyToOne
    @MapsId("Professor_id")
    @JoinColumn(name = "Professor_id", insertable = false, updatable = false)
    private Teacher teacher;

    public TeachId getTeachId() {
        return teachId;
    }

    public void setTeachId(TeachId teachId) {
        this.teachId = teachId;
    }

    public int getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(int disciplineId) {
        this.disciplineId = disciplineId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teach teach = (Teach) o;
        return disciplineId == teach.disciplineId &&
                teacherId == teach.teacherId &&
                Objects.equals(teachId, teach.teachId) &&
                Objects.equals(discipline, teach.discipline) &&
                Objects.equals(teacher, teach.teacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teachId, disciplineId, teacherId, discipline, teacher);
    }
}
