package com.github.lbovolini.escola.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class StudentGroupId implements Serializable {

    @Column(name = "Aluno_id")
    private int studentId;
    @Column(name = "Turma_id")
    private int groupId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentGroupId that = (StudentGroupId) o;
        return studentId == that.studentId &&
                groupId == that.groupId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, groupId);
    }
}
