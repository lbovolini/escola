package com.github.lbovolini.escola.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class ClassId implements Serializable {

    @Column(name = "Disciplina_id")
    private int disciplineId;
    @Column(name = "Turma_id")
    private int groupId;
    @Column(name = "day")
    @Temporal(TemporalType.DATE)
    private Date day;

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

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassId classId = (ClassId) o;
        return disciplineId == classId.disciplineId &&
                groupId == classId.groupId &&
                Objects.equals(day, classId.day);
    }

    @Override
    public int hashCode() {
        return Objects.hash(disciplineId, groupId, day);
    }
}
