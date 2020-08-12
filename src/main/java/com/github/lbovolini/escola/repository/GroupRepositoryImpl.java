package com.github.lbovolini.escola.repository;

import com.github.lbovolini.escola.dto.GroupDTO;
import com.github.lbovolini.escola.model.Group;
import com.github.lbovolini.escola.util.GroupUtil;

import java.util.ArrayList;
import java.util.List;

public class GroupRepositoryImpl extends RepositoryBase<Group> implements GroupRepository {

    @Override
    public void delete(int id) {
        String query = "DELETE FROM Group t WHERE t.id = ?1";

        List parameters = new ArrayList();
        parameters.add(id);

        executeDelete(query, parameters);
    }

    @Override
    public GroupDTO find(int id) {
        String query = "SELECT t FROM Group t WHERE t.id = ?1";

        List parameters = new ArrayList();
        parameters.add(id);

        Group group = (Group)executeSingle(query, parameters);

        return GroupUtil.toDTO(group);
    }

    @Override
    public void save(GroupDTO groupDTO) {
        Group group = GroupUtil.toModel(groupDTO);
        super.save(group);
    }

    @Override
    public void update(GroupDTO groupDTO) {
        GroupDTO groupDTO1 = find(groupDTO.getId());

        if (groupDTO1 == null) {
            return;
        }

        Group group = GroupUtil.toModel(groupDTO);
        super.update(group);
    }

}
