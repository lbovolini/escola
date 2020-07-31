package com.github.lbovolini.escola.repository;

import com.github.lbovolini.escola.model.Administrador;

import java.util.ArrayList;
import java.util.List;

public class AdministradorRepositoryImpl extends RepositoryBase<Administrador> implements AdministradorRepository {
    @Override
    public String findPassword(String email) {
        String query = "SELECT password FROM Administrador WHERE email = ?1";
        List parameters = new ArrayList<>();
        parameters.add(email);

        return (String)executeSingle(query, parameters);
    }
}
