package com.github.lbovolini.escola.service;

import com.github.lbovolini.escola.dto.GroupDTO;
import com.github.lbovolini.escola.repository.GroupRepository;

import javax.inject.Inject;

public class GroupService {

    private final GroupRepository groupRepository;

    @Inject
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public void delete(int id) {
        groupRepository.delete(id);
    }

    public GroupDTO find(int id) {
        return groupRepository.find(id);
    }

    public void save(GroupDTO groupDTO) {
        groupRepository.save(groupDTO);
    }

    public void update(GroupDTO groupDTO) {
        groupRepository.update(groupDTO);
    }

}
