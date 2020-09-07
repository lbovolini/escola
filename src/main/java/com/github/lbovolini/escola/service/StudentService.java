package com.github.lbovolini.escola.service;

import com.github.lbovolini.escola.dto.StudentDTO;
import com.github.lbovolini.escola.dto.StudentProfileDTO;
import com.github.lbovolini.escola.dto.DisciplineDTO;
import com.github.lbovolini.escola.dto.GroupDTO;
import com.github.lbovolini.escola.exception.InvalidPasswordException;
import com.github.lbovolini.escola.repository.StudentRepository;
import com.github.lbovolini.escola.validation.StudentValidation;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.inject.Inject;
import java.util.List;

public class StudentService {

    private final StudentRepository studentRepository;

    @Inject
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void delete(int id) {
        studentRepository.delete(id);
    }

    public StudentDTO find(int id) {
        return studentRepository.find(id);
    }

    public List<DisciplineDTO> findDisciplines(int id) {
        return studentRepository.findDisciplines(id);
    }

    public List<GroupDTO> findGroups(int alunoId) {
        return studentRepository.findGroups(alunoId);
    }

    public void save(StudentDTO studentDTO) {
        StudentValidation.validateCreate(studentDTO);
        studentDTO.setPassword(BCrypt.hashpw(studentDTO.getPassword(), BCrypt.gensalt(12)));
        studentRepository.save(studentDTO);
    }

    public void update(StudentDTO studentDTO) {

        String password = studentDTO.getPassword();

        if (!password.matches("[\\$\\S+\\$\\S+\\$\\S+]{60}")) {
            studentDTO.setPassword(BCrypt.hashpw(studentDTO.getPassword(), BCrypt.gensalt(12)));
        }

        StudentValidation.validateUpdate(studentDTO);
        studentRepository.update(studentDTO);
    }

    public void updateProfile(StudentProfileDTO studentProfileDTO) {

        StudentValidation.validateUpdateProfile(studentProfileDTO);
        validatePassword(studentProfileDTO.getId(), studentProfileDTO.getPassword());

        String newPassword = studentProfileDTO.getNewPassword();
        if (newPassword != null && !newPassword.isEmpty()) {
            studentProfileDTO.setNewPassword(BCrypt.hashpw(newPassword, BCrypt.gensalt(12)));
            studentRepository.updateProfileAndPassword(studentProfileDTO);
        }
        else {
            studentRepository.updateProfile(studentProfileDTO);
        }
    }

    private final void validatePassword(int id, String password) {
        StudentDTO studentDTO = studentRepository.find(id);

        if(!BCrypt.checkpw(password, studentDTO.getPassword())) {
            throw new InvalidPasswordException();
        }
    }
}
