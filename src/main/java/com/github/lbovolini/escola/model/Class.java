package com.github.lbovolini.escola.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Aula")
public class Class {

    @EmbeddedId
    private ClassId classId;
    @Column(name = "Disciplina_id", insertable = false, updatable = false)
    private int disciplineId;
    @Column(name = "Turma_id", insertable = false, updatable = false)
    private int groupId;

    @ManyToOne
    @MapsId("Disciplina_id")
    @JoinColumn(name = "Disciplina_id", insertable = false, updatable = false)
    private Discipline discipline;

    @ManyToOne
    @MapsId("Turma_id")
    @JoinColumn(name = "Turma_id", insertable = false, updatable = false)
    private Group group;

    public ClassId getClassId() {
        return classId;
    }

    public void setClassId(ClassId classId) {
        this.classId = classId;
    }

    public int getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(int disciplineId) {
        this.disciplineId = disciplineId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Class aClass = (Class) o;
        return disciplineId == aClass.disciplineId &&
                groupId == aClass.groupId &&
                Objects.equals(classId, aClass.classId) &&
                Objects.equals(discipline, aClass.discipline) &&
                Objects.equals(group, aClass.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classId, disciplineId, groupId, discipline, group);
    }
}
