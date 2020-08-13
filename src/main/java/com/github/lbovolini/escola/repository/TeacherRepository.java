package com.github.lbovolini.escola.repository;

import com.github.lbovolini.escola.dto.TeacherDTO;

public interface TeacherRepository {
    
    void delete(int id);

    TeacherDTO find(int id);

    TeacherDTO findByEmail(String email);

    String findPassword(String email);

    void save(TeacherDTO teacherDTO);

    void update(TeacherDTO teacherDTO);
}
