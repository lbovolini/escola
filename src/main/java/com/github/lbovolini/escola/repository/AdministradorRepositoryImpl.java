package com.github.lbovolini.escola.repository;

import com.github.lbovolini.escola.model.Administrador;

public class AdministradorRepositoryImpl extends RepositoryBase<Administrador> implements AdministradorRepository {
    @Override
    public String findPassword(String email) {
        String query = "SELECT password FROM Administrador WHERE email = " + email;
        return (String)executeSingle(query);
    }
}
