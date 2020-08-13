package com.github.lbovolini.escola.repository;

import com.github.lbovolini.escola.dto.AdministratorDTO;
import com.github.lbovolini.escola.model.Administrator;
import com.github.lbovolini.escola.util.AdministratorUtil;

import java.util.ArrayList;
import java.util.List;

public class AdministratorRepositoryImpl extends RepositoryBase<Administrator> implements AdministratorRepository {
    @Override
    public AdministratorDTO findByEmail(String email) {
        String query = "SELECT a FROM Administrator a WHERE a.email = ?1";

        List parameters = new ArrayList();
        parameters.add(email);

        Administrator administrator = (Administrator)executeSingle(query, parameters);

        return AdministratorUtil.toDTO(administrator);
    }

    @Override
    public String findPassword(String email) {
        String query = "SELECT password FROM Administrator WHERE email = ?1";
        List parameters = new ArrayList<>();
        parameters.add(email);

        return (String)executeSingle(query, parameters);
    }
}
