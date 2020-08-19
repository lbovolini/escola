package com.github.lbovolini.escola.repository;

import com.github.lbovolini.escola.dto.TeacherDTO;
import com.github.lbovolini.escola.model.Teacher;
import com.github.lbovolini.mapper.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class TeacherRepositoryImpl extends RepositoryBase<Teacher> implements TeacherRepository {
    @Override
    public void delete(int id) {
        String query = "DELETE FROM Teacher WHERE id = ?1";

        List parameters = new ArrayList();
        parameters.add(id);

        executeDelete(query, parameters);
    }

    @Override
    public TeacherDTO find(int id) {
        String query = "SELECT p FROM Teacher p WHERE p.id = ?1";

        List parameters = new ArrayList();
        parameters.add(id);

        Teacher teacher = (Teacher)executeSingle(query, parameters);

        return ObjectMapper.map(teacher, TeacherDTO.class);
    }

    @Override
    public TeacherDTO findByEmail(String email) {
        String query = "SELECT t FROM Teacher t WHERE t.email = ?1";

        List parameters = new ArrayList();
        parameters.add(email);

        Teacher teacher = (Teacher)executeSingle(query, parameters);

        return ObjectMapper.map(teacher, TeacherDTO.class);
    }

    @Override
    public String findPassword(String email) {
        String query = "SELECT password FROM Teacher WHERE email = ?1";
        List parameters = new ArrayList<>();
        parameters.add(email);

        return (String)executeSingle(query, parameters);
    }

    @Override
    public void save(TeacherDTO teacherDTO) {
        Teacher teacher = ObjectMapper.map(teacherDTO, Teacher.class);
        super.save(teacher);
    }

    @Override
    public void update(TeacherDTO teacherDTO) {
        TeacherDTO teacherDTO1 = find(teacherDTO.getId());

        if (teacherDTO1 == null) {
            return;
        }

        Teacher teacher = ObjectMapper.map(teacherDTO, Teacher.class);
        super.update(teacher);
    }
}
