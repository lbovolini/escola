package com.github.lbovolini.escola.service;

import com.github.lbovolini.escola.dto.AlunoDTO;
import com.github.lbovolini.escola.dto.AlunoProfileDTO;
import com.github.lbovolini.escola.dto.DisciplinaDTO;
import com.github.lbovolini.escola.dto.TurmaDTO;
import com.github.lbovolini.escola.exception.InvalidPasswordException;
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

    public void update(AlunoDTO alunoDTO) {

        String password = alunoDTO.getPassword();

        if (!password.matches("[\\$\\S+\\$\\S+\\$\\S+]{60}")) {
            alunoDTO.setPassword(BCrypt.hashpw(alunoDTO.getPassword(), BCrypt.gensalt(12)));
        }

        AlunoUtil.validateAll(alunoDTO);
        alunoRepository.update(alunoDTO);
    }

    public void updateProfile(AlunoProfileDTO alunoProfileDTO) {

        AlunoUtil.validateProfile(alunoProfileDTO);
        validatePassword(alunoProfileDTO.getId(), alunoProfileDTO.getPassword());

        String newPassword = alunoProfileDTO.getNewPassword();
        if (newPassword != null && !newPassword.isEmpty()) {
            alunoProfileDTO.setNewPassword(BCrypt.hashpw(newPassword, BCrypt.gensalt(12)));
            alunoRepository.updateProfileAndPassword(alunoProfileDTO);
        }
        else {
            alunoRepository.updateProfile(alunoProfileDTO);
        }
    }

    private final void validatePassword(int id, String password) {
        AlunoDTO alunoDTO = alunoRepository.find(id);

        if(!BCrypt.checkpw(password, alunoDTO.getPassword())) {
            throw new InvalidPasswordException();
        }
    }
}
