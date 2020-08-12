package com.github.lbovolini.escola.dto;

import java.util.Objects;

public class TurmaDTO {

    private int id;
    private String number;
    private int courseId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TurmaDTO turmaDTO = (TurmaDTO) o;
        return id == turmaDTO.id &&
                courseId == turmaDTO.courseId &&
                Objects.equals(number, turmaDTO.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, courseId);
    }
}
