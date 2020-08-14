package com.github.lbovolini.escola.validation;

import com.github.lbovolini.escola.dto.TeacherDTO;
import com.github.lbovolini.escola.exception.InvalidFormException;
import com.github.lbovolini.escola.message.InputError;

import java.util.ArrayList;
import java.util.List;

public class TeacherValidation {

    public static void validateCreate(TeacherDTO teacherDTO) {
        validateCreate(teacherDTO, new ArrayList<>());
    }

    private static void validateCreate(TeacherDTO teacherDTO, List<InputError> errors) {

        String name = teacherDTO.getName();
        if (name == null || name.isEmpty()) {
            errors.add(new InputError("name", "Name is required"));
        }

        String email = teacherDTO.getEmail();
        if (email == null || email.isEmpty()) {
            errors.add(new InputError("email", "Email is required"));
        }
        else {
            if (!email.matches("^\\S+@\\S+$")) {
                errors.add(new InputError("email", "Invalid email address"));
            }
        }

        String password = teacherDTO.getPassword();
        if (password == null || password.isEmpty()) {
            errors.add(new InputError("password", "Password is required"));
        }
        else {
            if (!password.matches("^\\$\\d{2}\\$\\S{53}")) {
                if (!password.matches("^(?=.*[\\d])(?=.*[a-z])[\\w!@#$%^&*()-=+,.;:]{8,}$")) {
                    errors.add(new InputError("password", "Password require minimum eight characters, at least one letter and one number"));
                }
            }
        }

        if (!errors.isEmpty()) {
            throw new InvalidFormException(errors);
        }
    }

    public static void validateUpdate(TeacherDTO teacherDTO) {

        List<InputError> errors = new ArrayList<>();

        int id = teacherDTO.getId();
        if(id == 0) {
            errors.add(new InputError("id", "Id is required"));
        }

        validateCreate(teacherDTO, errors);
    }
}
