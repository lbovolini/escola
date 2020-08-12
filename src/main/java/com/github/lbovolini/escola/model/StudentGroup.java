package com.github.lbovolini.escola.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "AlunoTurma")
public class StudentGroup {

    @EmbeddedId
    private StudentGroupId studentGroupId;
    @Column(name = "Aluno_id", insertable = false, updatable = false)
    private int studentId;
    @Column(name = "Turma_id", insertable = false, updatable = false)
    private int groupId;

    @ManyToOne
    @MapsId("Aluno_id")
    @JoinColumn(name = "Aluno_id", insertable = false, updatable = false)
    private Student student;

    @ManyToOne
    @MapsId("Turma_id")
    @JoinColumn(name = "Turma_id", insertable = false, updatable = false)
    private Group group;

    public StudentGroupId getStudentGroupId() {
        return studentGroupId;
    }

    public void setStudentGroupId(StudentGroupId studentGroupId) {
        this.studentGroupId = studentGroupId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentGroup that = (StudentGroup) o;
        return studentId == that.studentId &&
                groupId == that.groupId &&
                Objects.equals(studentGroupId, that.studentGroupId) &&
                Objects.equals(student, that.student) &&
                Objects.equals(group, that.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentGroupId, studentId, groupId, student, group);
    }
}
