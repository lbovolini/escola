package com.github.lbovolini.escola.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Curso")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    //@OneToMany(mappedBy = "course", fetch=FetchType.EAGER)
    //private List<Student> studentList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id &&
                Objects.equals(name, course.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
