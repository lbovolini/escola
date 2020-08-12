package com.github.lbovolini.escola.dto;

import java.util.Date;
import java.util.Objects;

public class ClassDTO {

    private int disciplineId;
    private int groupId;
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
        ClassDTO classDTO = (ClassDTO) o;
        return disciplineId == classDTO.disciplineId &&
                groupId == classDTO.groupId &&
                Objects.equals(day, classDTO.day);
    }

    @Override
    public int hashCode() {
        return Objects.hash(disciplineId, groupId, day);
    }
}
