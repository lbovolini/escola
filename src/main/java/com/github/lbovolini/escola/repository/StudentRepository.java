package com.github.lbovolini.escola.repository;

import com.github.lbovolini.escola.dto.StudentDTO;
import com.github.lbovolini.escola.dto.StudentProfileDTO;
import com.github.lbovolini.escola.dto.DisciplineDTO;
import com.github.lbovolini.escola.dto.GroupDTO;

import java.util.List;

public interface StudentRepository {

    void delete(int id);

    StudentDTO find(int id);

    StudentDTO findByEmail(String email);

    List<DisciplineDTO> findDisciplines(int id);

    String findPassword(String email);

    List<GroupDTO> findGroups(int id);

    void save(StudentDTO aluno);

    void update(StudentDTO studentDTO);

    void updateProfile(StudentProfileDTO studentProfileDTO);

    void updateProfileAndPassword(StudentProfileDTO studentProfileDTO);
}
