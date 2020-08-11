package com.github.lbovolini.escola.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;
    private LocalDate birthday;

    @OneToOne
    @JoinColumn(name = "Curso_id", referencedColumnName = "id")
    private Curso curso;

    public Aluno() {
    }

    public Aluno(int id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return id == aluno.id &&
                Objects.equals(name, aluno.name) &&
                Objects.equals(email, aluno.email) &&
                Objects.equals(password, aluno.password) &&
                Objects.equals(birthday, aluno.birthday) &&
                Objects.equals(curso, aluno.curso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password, birthday, curso);
    }
}
