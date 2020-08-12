package com.github.lbovolini.escola.dto;

import java.util.Objects;

public class GradeCurricularDTO {

    private int id;
    private int year;
    private int courseId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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
        GradeCurricularDTO that = (GradeCurricularDTO) o;
        return id == that.id &&
                year == that.year &&
                courseId == that.courseId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, year, courseId);
    }
}
