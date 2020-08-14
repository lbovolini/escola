package com.github.lbovolini.escola.validation;

import com.github.lbovolini.escola.dto.StudentDTO;
import com.github.lbovolini.escola.dto.StudentProfileDTO;
import com.github.lbovolini.escola.exception.InvalidFormException;
import com.github.lbovolini.escola.message.InputError;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentValidation {

    public static void validateCreate(StudentDTO studentDTO) {
        validateCreate(studentDTO, new ArrayList<>());
    }

    private static void validateCreate(StudentDTO studentDTO, List<InputError> errors) {

        String name = studentDTO.getName();
        if (name == null || name.isEmpty()) {
            errors.add(new InputError("name", "Name is required"));
        }

        String email = studentDTO.getEmail();
        if (email == null || email.isEmpty()) {
            errors.add(new InputError("email", "Email is required"));
        }
        else {
            if (!email.matches("^\\S+@\\S+$")) {
                errors.add(new InputError("email", "Invalid email address"));
            }
        }

        String password = studentDTO.getPassword();
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

        LocalDate birthday = studentDTO.getBirthday();
        if (birthday == null) {
            errors.add(new InputError("birthday", "Birthday is required"));
        }

        int courseId = studentDTO.getCourseId();
        if (courseId == 0) {
            errors.add(new InputError("courseId", "Course is required"));
        }

        if (!errors.isEmpty()) {
            throw new InvalidFormException(errors);
        }
    }

    public static void validateUpdate(StudentDTO studentDTO) {

        List<InputError> errors = new ArrayList<>();

        int id = studentDTO.getId();
        if (id == 0) {
            errors.add(new InputError("id", "Id is required"));
        }
        validateCreate(studentDTO, errors);
    }

    public static void validateUpdateProfile(StudentProfileDTO studentProfileDTO) {

        List<InputError> errors = new ArrayList<>();

        int id = studentProfileDTO.getId();
        if (id == 0) {
            errors.add(new InputError("id", "Id is required"));
        }

        String name = studentProfileDTO.getName();
        if (name == null || name.isEmpty()) {
            errors.add(new InputError("name","Name is required"));
        }

        String email = studentProfileDTO.getEmail();
        if (email == null || email.isEmpty()) {
            errors.add(new InputError("email", "Email is required"));
        }
        else {
            if (!email.matches("^\\S+@\\S+$")) {
                errors.add(new InputError("email", "Invalid email address"));
            }
        }

        String password = studentProfileDTO.getPassword();
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

        String newPassword = studentProfileDTO.getNewPassword();
        if (newPassword == null || newPassword.isEmpty()) {
            errors.add(new InputError("newPassword", "Password require minimum eight characters, at least one letter and one number"));
        }
        else {
            if (!password.matches("^(?=.*[\\d])(?=.*[a-z])[\\w!@#$%^&*()-=+,.;:]{8,}$")) {
                errors.add(new InputError("newPassword", "Password require minimum eight characters, at least one letter and one number"));
            }
        }

        LocalDate birthday = studentProfileDTO.getBirthday();
        if (birthday == null) {
            errors.add(new InputError("birthday", "Birthday is required"));
        }

        if (!errors.isEmpty()) {
            throw new InvalidFormException(errors);
        }
    }
}
