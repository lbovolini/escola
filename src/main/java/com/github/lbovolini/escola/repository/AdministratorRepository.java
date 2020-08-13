package com.github.lbovolini.escola.repository;

import com.github.lbovolini.escola.dto.AdministratorDTO;

public interface AdministratorRepository {

    AdministratorDTO findByEmail(String email);

    String findPassword(String email);
}
