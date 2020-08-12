package com.github.lbovolini.escola.repository;

import com.github.lbovolini.escola.model.Administrator;

import java.util.ArrayList;
import java.util.List;

public class AdministratorRepositoryImpl extends RepositoryBase<Administrator> implements AdministratorRepository {
    @Override
    public String findPassword(String email) {
        String query = "SELECT password FROM Administrator WHERE email = ?1";
        List parameters = new ArrayList<>();
        parameters.add(email);

        return (String)executeSingle(query, parameters);
    }
}
