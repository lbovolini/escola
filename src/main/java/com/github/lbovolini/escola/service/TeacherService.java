package com.github.lbovolini.escola.service;

import com.github.lbovolini.escola.dto.TeacherDTO;
import com.github.lbovolini.escola.repository.TeacherRepository;
import com.github.lbovolini.escola.util.TeacherUtil;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.inject.Inject;

public class TeacherService {

    private final TeacherRepository teacherRepository;

    @Inject
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public void delete(int id) {
        teacherRepository.delete(id);
    }

    public TeacherDTO find(int id) {
        return teacherRepository.find(id);
    }

    public void save(TeacherDTO teacherDTO) {
        TeacherUtil.validate(teacherDTO);
        teacherDTO.setPassword(BCrypt.hashpw(teacherDTO.getPassword(), BCrypt.gensalt(12)));
        teacherRepository.save(teacherDTO);
    }

    public void update(TeacherDTO teacherDTO) {
        String password = teacherDTO.getPassword();

        if (!password.matches("[\\$\\S+\\$\\S+\\$\\S+]{60}")) {
            teacherDTO.setPassword(BCrypt.hashpw(teacherDTO.getPassword(), BCrypt.gensalt(12)));
        }

        TeacherUtil.validateAll(teacherDTO);
        teacherRepository.update(teacherDTO);
    }
}
