package com.github.lbovolini.escola.service;

import com.github.lbovolini.escola.dto.ProfessorDTO;
import com.github.lbovolini.escola.repository.ProfessorRepository;
import com.github.lbovolini.escola.repository.ProfessorRepositoryImpl;
import com.github.lbovolini.escola.util.AlunoUtil;
import com.github.lbovolini.escola.util.ProfessorUtil;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class ProfessorService {

    private ProfessorRepository professorRepository;

    public ProfessorService() {
        this.professorRepository = new ProfessorRepositoryImpl();
    }

    public void delete(int id) {
        professorRepository.delete(id);
    }

    public ProfessorDTO find(int id) {
        return professorRepository.find(id);
    }

    public void save(ProfessorDTO professorDTO) {
        ProfessorUtil.validate(professorDTO);
        professorDTO.setPassword(BCrypt.hashpw(professorDTO.getPassword(), BCrypt.gensalt(12)));
        professorRepository.save(professorDTO);
    }

    public void update(ProfessorDTO professorDTO) {
        String password = professorDTO.getPassword();

        if (!password.matches("[\\$\\S+\\$\\S+\\$\\S+]{60}")) {
            professorDTO.setPassword(BCrypt.hashpw(professorDTO.getPassword(), BCrypt.gensalt(12)));
        }

        ProfessorUtil.validateAll(professorDTO);
        professorRepository.update(professorDTO);
    }
}
