package com.github.lbovolini.escola.util;

import com.github.lbovolini.escola.dto.AlunoDTO;
import com.github.lbovolini.escola.dto.AlunoProfileDTO;
import com.github.lbovolini.escola.dto.CursoDTO;
import com.github.lbovolini.escola.dto.UsuarioDTO;
import com.github.lbovolini.escola.model.Aluno;
import com.github.lbovolini.escola.model.Curso;

import java.time.LocalDate;

public class AlunoUtil {

    public static AlunoDTO toDTO(Aluno aluno) {
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setId(aluno.getId());
        alunoDTO.setName(aluno.getName());
        alunoDTO.setEmail(aluno.getEmail());
        alunoDTO.setPassword(aluno.getPassword());
        alunoDTO.setBirthday(aluno.getBirthday());
        alunoDTO.setCursoDTO(CursoUtil.toDTO(aluno.getCurso()));

        return alunoDTO;
    }

    public static Aluno toModel(AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno();
        aluno.setId(alunoDTO.getId());
        aluno.setName(alunoDTO.getName());
        aluno.setEmail(alunoDTO.getEmail());
        aluno.setPassword(alunoDTO.getPassword());
        aluno.setBirthday(alunoDTO.getBirthday());
        aluno.setCurso(new Curso(alunoDTO.getCursoDTO().getId()));

        return aluno;
    }

    public static UsuarioDTO toUsuarioDTO(AlunoDTO alunoDTO, String role, String token) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(alunoDTO.getId());
        usuarioDTO.setName(alunoDTO.getName());
        usuarioDTO.setEmail(alunoDTO.getEmail());
        usuarioDTO.setRole(role);
        usuarioDTO.setToken(token);

        return usuarioDTO;
    }

    public static void validate(AlunoDTO alunoDTO) {

        String name = alunoDTO.getName();
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name is required");
        }

        String email = alunoDTO.getEmail();
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email is required");
        }

        if (!email.matches("^\\S+@\\S+$")) {
            throw new IllegalArgumentException("Invalid email address");
        }

        String password = alunoDTO.getPassword();
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password is required");
        }

        if (!password.matches("[\\$\\S+\\$\\S+\\$\\S+]{60}")) {
            if (!password.matches("^(?=.*[\\d])(?=.*[a-z])[\\w!@#$%^&*()-=+,.;:]{8,}$")) {
                throw new IllegalArgumentException("Password require minimum eight characters, at least one letter and one number");
            }
        }

        LocalDate birthday = alunoDTO.getBirthday();
        if (birthday == null) {
            throw new IllegalArgumentException("Birthday is required");
        }

        CursoDTO cursoDTO = alunoDTO.getCursoDTO();
        if (cursoDTO == null || cursoDTO.getId() == 0) {
            throw new IllegalArgumentException("Course is required");
        }
    }

    public static void validateAll(AlunoDTO alunoDTO) {

        int id = alunoDTO.getId();
        if(id == 0) {
            throw new IllegalArgumentException("Id is required");
        }
        validate(alunoDTO);
    }

    public static void validateProfile(AlunoProfileDTO alunoProfileDTO) {

        String name = alunoProfileDTO.getName();
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name is required");
        }

        String email = alunoProfileDTO.getEmail();
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email is required");
        }

        if (!email.matches("^\\S+@\\S+$")) {
            throw new IllegalArgumentException("Invalid email address");
        }

        String password = alunoProfileDTO.getPassword();
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password is required");
        }

        if (!password.matches("[\\$\\S+\\$\\S+\\$\\S+]{60}")) {
            if (!password.matches("^(?=.*[\\d])(?=.*[a-z])[\\w!@#$%^&*()-=+,.;:]{8,}$")) {
                throw new IllegalArgumentException("Password require minimum eight characters, at least one letter and one number");
            }
        }

        String newPassword = alunoProfileDTO.getNewPassword();
        if (newPassword != null && !newPassword.isEmpty()) {
            if (!password.matches("^(?=.*[\\d])(?=.*[a-z])[\\w!@#$%^&*()-=+,.;:]{8,}$")) {
                throw new IllegalArgumentException("Password require minimum eight characters, at least one letter and one number");
            }
        }

        LocalDate birthday = alunoProfileDTO.getBirthday();
        if (birthday == null) {
            throw new IllegalArgumentException("Birthday is required");
        }
    }

}
