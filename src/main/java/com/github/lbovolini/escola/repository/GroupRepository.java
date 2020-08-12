package com.github.lbovolini.escola.repository;

import com.github.lbovolini.escola.dto.GroupDTO;

public interface GroupRepository {

    void delete(int id);

    GroupDTO find(int id);

    void save(GroupDTO groupDTO);

    void update(GroupDTO groupDTO);
}
