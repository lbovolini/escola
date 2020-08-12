package com.github.lbovolini.escola.util;

import com.github.lbovolini.escola.dto.GroupDTO;
import com.github.lbovolini.escola.model.Group;

public class GroupUtil {

    public static GroupDTO toDTO(Group group) {
        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setId(group.getId());
        groupDTO.setNumber(group.getNumber());
        groupDTO.setCourseId(group.getCourseId());

        return groupDTO;
    }

    public static Group toModel(GroupDTO groupDTO) {
        Group group = new Group();
        group.setId(groupDTO.getId());
        group.setNumber(groupDTO.getNumber());
        group.setCourseId(groupDTO.getCourseId());

        return group;
    }
}
