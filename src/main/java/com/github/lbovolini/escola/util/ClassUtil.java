package com.github.lbovolini.escola.util;

import com.github.lbovolini.escola.dto.ClassDTO;
import com.github.lbovolini.escola.model.Class;
import com.github.lbovolini.escola.model.ClassId;

public class ClassUtil {

    public static ClassDTO toDTO(Class aClass) {
        ClassDTO classDTO = new ClassDTO();
        classDTO.setDisciplineId(aClass.getClassId().getDisciplineId());
        classDTO.setGroupId(aClass.getClassId().getGroupId());
        classDTO.setDay(aClass.getClassId().getDay());

        return classDTO;
    }

    public static Class toModel(ClassDTO classDTO) {
        ClassId classId = new ClassId();
        classId.setDisciplineId(classDTO.getDisciplineId());
        classId.setGroupId(classDTO.getGroupId());
        classId.setDay(classDTO.getDay());

        Class aClass = new Class();
        aClass.setClassId(classId);

        return aClass;
    }
}
