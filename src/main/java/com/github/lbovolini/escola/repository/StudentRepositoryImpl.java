package com.github.lbovolini.escola.repository;

import com.github.lbovolini.escola.dto.StudentDTO;
import com.github.lbovolini.escola.dto.StudentProfileDTO;
import com.github.lbovolini.escola.dto.DisciplineDTO;
import com.github.lbovolini.escola.dto.GroupDTO;
import com.github.lbovolini.escola.model.Student;
import com.github.lbovolini.escola.model.Discipline;
import com.github.lbovolini.escola.model.Group;
import com.github.lbovolini.mapper.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl extends RepositoryBase<Student> implements StudentRepository {

    @Override
    public void delete(int id) {
        String query = "DELETE FROM Student a WHERE a.id = ?1";

        List parameters = new ArrayList();
        parameters.add(id);

        executeDelete(query, parameters);
    }

    @Override
    public StudentDTO find(int id) {
        String query = "SELECT a FROM Student a WHERE a.id = ?1";

        List parameters = new ArrayList();
        parameters.add(id);

        Student student = (Student)executeSingle(query, parameters);

        return ObjectMapper.map(student, StudentDTO.class);
    }

    @Override
    public StudentDTO findByEmail(String email) {
        String query = "SELECT a FROM Student a WHERE a.email = ?1";
        List parameters = new ArrayList();
        parameters.add(email);

        Student student = (Student)executeSingle(query, parameters);

        return ObjectMapper.map(student, StudentDTO.class);
    }

    @Override
    public List<DisciplineDTO> findDisciplines(int alunoId) {
        String query = "SELECT d FROM Enrollment m JOIN Discipline d ON m.disciplineId = d.id JOIN Student a ON m.studentId = a.id WHERE a.id = ?1";

        List parameters = new ArrayList();
        parameters.add(alunoId);

        List<Discipline> disciplineList = execute(query, parameters);

        return ObjectMapper.map(disciplineList, DisciplineDTO.class);
    }

    @Override
    public String findPassword(String email) {
        String query = "SELECT a.password FROM Student a WHERE a.email = ?1";

        List parameters = new ArrayList();
        parameters.add(email);

        String password = (String)executeSingle(query, parameters);

        return password;
    }

    @Override
    public List<GroupDTO> findGroups(int alunoId) {
        String query = "SELECT t FROM StudentGroup at JOIN Group t ON at.groupId = t.id JOIN Student a ON a.id = at.studentId WHERE a.id = ?1";

        List parameters = new ArrayList();
        parameters.add(alunoId);

        List<Group> groupList = execute(query, parameters);

        return ObjectMapper.map(groupList, GroupDTO.class);
    }

    @Override
    public void save(StudentDTO studentDTO) {
        Student student = ObjectMapper.map(studentDTO, Student.class);
        super.save(student);
    }

    @Override
    public void update(StudentDTO studentDTO) {

        StudentDTO studentDTO1 = find(studentDTO.getId());

        if (studentDTO1 == null) {
            return;
        }

        Student student = ObjectMapper.map(studentDTO, Student.class);
        super.update(student);
    }

    @Override
    public void updateProfile(StudentProfileDTO studentProfileDTO) {
        String query = "UPDATE Student SET name = ?1, email = ?2, birthday = ?3 WHERE id = ?4";

        List parameters = new ArrayList();
        parameters.add(studentProfileDTO.getName());
        parameters.add(studentProfileDTO.getEmail());
        parameters.add(studentProfileDTO.getBirthday());
        parameters.add(studentProfileDTO.getId());

        executeUpdate(query, parameters);
    }

    @Override
    public void updateProfileAndPassword(StudentProfileDTO studentProfileDTO) {
        String query = "UPDATE Student SET name = ?1, email = ?2, birthday = ?3, password = ?4 WHERE id = ?5";

        List parameters = new ArrayList();
        parameters.add(studentProfileDTO.getName());
        parameters.add(studentProfileDTO.getEmail());
        parameters.add(studentProfileDTO.getBirthday());
        parameters.add(studentProfileDTO.getNewPassword());
        parameters.add(studentProfileDTO.getId());

        executeUpdate(query, parameters);
    }

}
