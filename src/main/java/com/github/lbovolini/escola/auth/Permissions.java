package com.github.lbovolini.escola.auth;

import java.util.HashMap;
import java.util.Map;

public class Permissions {

    private static class Permission {

        private String administrator;
        private String student;
        private String teacher;

        public Permission(String student, String teacher, String administrator) {
            this.student = student;
            this.teacher = teacher;
            this.administrator = administrator;
        }

        public boolean has(String role, String method) {

            if (role.equals(Role.student())) {
                if (student.equals("*")) {
                    return true;
                }
                return student.contains(method);
            }
            if (role.equals(Role.teacher())) {
                if (teacher.equals("*")) {
                    return true;
                }
                return teacher.contains(method);
            }
            if (role.equals(Role.administrator())) {
                if (administrator.equals("*")) {
                    return true;
                }
                return administrator.contains(method);
            }

            return false;
        }
    }

    private static final String API = "api/v1";
    private static final Map<String, Permission> permissions = new HashMap<>();

    static {
        // AlunoController
        permissions.put("/students", new Permission("POST", "", "*"));
        permissions.put("/students/id", new Permission("GET", "GET", "*"));
        permissions.put("/students/id/disciplines", new Permission("GET", "GET", "*"));
        permissions.put("/students/id/groups", new Permission("GET", "GET", "*"));
        permissions.put("/students/profile", new Permission("PUT", "", "*"));
        // CursoController
        permissions.put("/courses", new Permission("GET", "GET PUT", "*"));
        permissions.put("/courses/id", new Permission("GET", "GET", "*"));
        permissions.put("/courses/curriculum/id", new Permission("GET", "GET", "*"));
        // DisciplinaController
        permissions.put("/disciplines", new Permission("", "POST PUT", "*"));
        permissions.put("/disciplines/id", new Permission("GET", "DELETE GET", "*"));
        permissions.put("/disciplines/id/classes/id", new Permission("GET", "GET", "*"));
        // GradeCurricularController
        permissions.put("/curriculum", new Permission("", "POST PUT", "*"));
        permissions.put("/curriculum/id", new Permission("GET", "DELETE GET", "*"));
        permissions.put("/curriculum/id/disciplines", new Permission("GET", "GET", "*"));
        // ProfessorController
        permissions.put("/teachers", new Permission("", "POST PUT", "*"));
        permissions.put("/teachers/id", new Permission("", "GET", "*"));
        // TurmaController
        permissions.put("/groups", new Permission("GET", "GET POST PUT", "*"));
        permissions.put("/groups/id", new Permission("GET", "DELETE GET", "*"));
    }

    public static boolean isAuthorized(String path, String method, String role) {

        String[] strings = path.split("/", 3);
        String pathString = strings[2].replace(API, "").replaceAll("\\d+", "id");

        if (pathString.endsWith("/")) {
            pathString = pathString.substring(0, pathString.length() - 1);
        }

        Permission permission = permissions.get(pathString);

        if (permission == null) {
            throw new RuntimeException("Unregistered permissions for route.");
        }

        return permission.has(role, method);
    }

}
