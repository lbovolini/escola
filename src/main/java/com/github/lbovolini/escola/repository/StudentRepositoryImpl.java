package com.github.lbovolini.escola.repository;

import com.github.lbovolini.escola.dto.StudentDTO;
import com.github.lbovolini.escola.dto.StudentProfileDTO;
import com.github.lbovolini.escola.dto.DisciplineDTO;
import com.github.lbovolini.escola.dto.GroupDTO;
import com.github.lbovolini.escola.model.Student;
import com.github.lbovolini.escola.model.Discipline;
import com.github.lbovolini.escola.model.Group;
import com.github.lbovolini.escola.util.StudentUtil;
import com.github.lbovolini.escola.util.DisciplineUtil;
import com.github.lbovolini.escola.util.GroupUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

        return StudentUtil.toDTO(student);
    }

    @Override
    public StudentDTO findByEmail(String email) {
        String query = "SELECT a FROM Student a WHERE a.email = ?1";
        List parameters = new ArrayList();
        parameters.add(email);

        Student student = (Student)executeSingle(query, parameters);

        return StudentUtil.toDTO(student);
    }

    @Override
    public List<DisciplineDTO> findDisciplinas(int alunoId) {
        String query = "SELECT d FROM Enrollment m JOIN Discipline d ON m.disciplineId = d.id JOIN Student a ON m.studentId = a.id WHERE a.id = ?1";

        List parameters = new ArrayList();
        parameters.add(alunoId);

        List<Discipline> disciplineList = execute(query, parameters);
        List<DisciplineDTO> disciplineDTOList = disciplineList.stream().map(DisciplineUtil::toDTO).collect(Collectors.toList());

        return disciplineDTOList;
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
    public List<GroupDTO> findTurmas(int alunoId) {
        String query = "SELECT t FROM StudentGroup at JOIN Group t ON at.groupId = t.id JOIN Student a ON a.id = at.studentId WHERE a.id = ?1";

        List parameters = new ArrayList();
        parameters.add(alunoId);

        List<Group> groupList = execute(query, parameters);
        List<GroupDTO> groupDTOList = groupList.stream().map(GroupUtil::toDTO).collect(Collectors.toList());

        return groupDTOList;
    }

    @Override
    public void save(StudentDTO studentDTO) {
        Student student = StudentUtil.toModel(studentDTO);
        super.save(student);
    }

    @Override
    public void update(StudentDTO studentDTO) {

        StudentDTO studentDTO1 = find(studentDTO.getId());

        if (studentDTO1 == null) {
            return;
        }

        Student student = StudentUtil.toModel(studentDTO);
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
