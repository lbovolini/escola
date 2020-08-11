package com.github.lbovolini.escola.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;
import java.util.Objects;

public class AlunoDTO {

    private int id;
    private String name;
    private String email;
    private String password;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate birthday;
    private CursoDTO cursoDTO;

    public AlunoDTO() {
    }

    public AlunoDTO(int id) {
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

    public CursoDTO getCursoDTO() {
        return cursoDTO;
    }

    public void setCursoDTO(CursoDTO cursoDTO) {
        this.cursoDTO = cursoDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlunoDTO alunoDTO = (AlunoDTO) o;
        return id == alunoDTO.id &&
                Objects.equals(name, alunoDTO.name) &&
                Objects.equals(email, alunoDTO.email) &&
                Objects.equals(password, alunoDTO.password) &&
                Objects.equals(birthday, alunoDTO.birthday) &&
                Objects.equals(cursoDTO, alunoDTO.cursoDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password, birthday, cursoDTO);
    }
}
