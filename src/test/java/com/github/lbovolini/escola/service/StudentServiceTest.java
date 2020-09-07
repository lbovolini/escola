package com.github.lbovolini.escola.service;

import com.github.lbovolini.escola.dto.GroupDTO;
import com.github.lbovolini.escola.dto.StudentDTO;
import com.github.lbovolini.escola.repository.StudentRepository;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    private final static int id = 1;
    private final static String name = "Lucas Bovolini";
    private final static String email = "lucasbovolini@hotmail.com";
    private final static String password = "password123";
    private final static LocalDate birthday = LocalDate.of(1994, 7, 18);
    private final static int courseId = 1;

    private final static StudentDTO studentDTO = new StudentDTO();

    static {
        studentDTO.setId(id);
        studentDTO.setName(name);
        studentDTO.setEmail(email);
        studentDTO.setBirthday(birthday);
        studentDTO.setPassword(password);
        studentDTO.setCourseId(courseId);
    }

    @Test
    void shouldDeleteStudent() {
        StudentRepository studentRepository = mock(StudentRepository.class);

        StudentService studentService = new StudentService(studentRepository);
        studentService.delete(1);

        verify(studentRepository).delete(1);
    }

    @Test
    void shouldFindStudentById() {

        StudentRepository studentRepository = mock(StudentRepository.class);
        when(studentRepository.find(1)).thenReturn(studentDTO);

        StudentService studentService = new StudentService(studentRepository);
        StudentDTO s = studentService.find(1);
        assertEquals(studentDTO, s);
    }

    @Test
    void shouldFindGroups() {

        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setId(1);
        groupDTO.setNumber("1");
        groupDTO.setCourseId(1);

        List<GroupDTO> groupDTOList = new ArrayList<>();

        StudentRepository studentRepository = mock(StudentRepository.class);
        when(studentRepository.findGroups(1)).thenReturn(groupDTOList);

        StudentService studentService = new StudentService(studentRepository);
        assertEquals(groupDTOList, studentService.findGroups(1));
    }

    @Test
    void shouldSaveStudent() {

        StudentRepository studentRepository = mock(StudentRepository.class);

        StudentService studentService = new StudentService(studentRepository);
        studentService.save(studentDTO);

        verify(studentRepository).save(studentDTO);
    }

    @Test
    void shouldUpdateStudent() {
        StudentRepository studentRepository = mock(StudentRepository.class);

        StudentService studentService = new StudentService(studentRepository);
        studentService.update(studentDTO);

        verify(studentRepository).update(studentDTO);
    }

}