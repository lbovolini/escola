package com.github.lbovolini.escola.service;

import com.github.lbovolini.escola.dto.AlunoDTO;
import com.github.lbovolini.escola.dto.DisciplinaDTO;
import com.github.lbovolini.escola.dto.TurmaDTO;
import com.github.lbovolini.escola.repository.AlunoRepository;
import com.github.lbovolini.escola.repository.AlunoRepositoryImpl;
import com.github.lbovolini.escola.util.AlunoUtil;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.List;

public class AlunoService {

    private AlunoRepository alunoRepository;

    public AlunoService() {
        this.alunoRepository = new AlunoRepositoryImpl();
    }

    public void delete(int id) {
        alunoRepository.delete(id);
    }

    public AlunoDTO find(int id) {
        return alunoRepository.find(id);
    }

    public List<DisciplinaDTO> findDisciplinas(int id) {
        return alunoRepository.findDisciplinas(id);
    }

    public List<TurmaDTO> findTurmas(int alunoId) {
        return alunoRepository.findTurmas(alunoId);
    }

    public void save(AlunoDTO alunoDTO) {
        AlunoUtil.validate(alunoDTO);
        alunoDTO.setPassword(BCrypt.hashpw(alunoDTO.getPassword(), BCrypt.gensalt(12)));
        alunoRepository.save(alunoDTO);
    }

    public void update(AlunoDTO alunoDto) {
        AlunoUtil.validateWithId(alunoDto);
        alunoRepository.update(alunoDto);
    }

}
