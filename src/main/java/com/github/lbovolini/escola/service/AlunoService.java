package com.github.lbovolini.escola.service;

import com.github.lbovolini.escola.dto.AlunoDTO;
import com.github.lbovolini.escola.model.Aluno;
import com.github.lbovolini.escola.repository.AlunoRepository;
import com.github.lbovolini.escola.repository.AlunoRepositoryImpl;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class AlunoService {

    private AlunoRepository alunoRepository;

    public AlunoService() {
        this.alunoRepository = new AlunoRepositoryImpl();
    }

    public Aluno find(int id) {
        return alunoRepository.find(id);
    }

    public void save(AlunoDTO alunoDto) {

        Aluno aluno = new Aluno();
        aluno.setId(alunoDto.id);
        aluno.setName(alunoDto.name);
        aluno.setEmail(alunoDto.email);
        aluno.setPassword(BCrypt.hashpw(alunoDto.password, BCrypt.gensalt(12)));
        aluno.setBirthday(alunoDto.birthday);
        aluno.setCurso(alunoDto.curso);

        alunoRepository.save(aluno);
    }

    public void delete(int id) {
        alunoRepository.delete(id);
    }

    public void update(AlunoDTO alunoDto) {

        Aluno aluno = new Aluno();
        aluno.setId(alunoDto.id);
        aluno.setName(alunoDto.name);
        aluno.setEmail(alunoDto.email);
        aluno.setBirthday(alunoDto.birthday);
        aluno.setCurso(alunoDto.curso);

        alunoRepository.update(aluno);
    }
}
