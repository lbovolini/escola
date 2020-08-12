package com.github.lbovolini.escola.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Turma")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String number;
    @Column(name = "Curso_id")
    private int courseId;

    @ManyToOne
    @JoinColumn(name = "Curso_id", insertable = false, updatable = false)
    private Course course;

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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return id == group.id &&
                courseId == group.courseId &&
                Objects.equals(number, group.number) &&
                Objects.equals(course, group.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, courseId, course);
    }
}
