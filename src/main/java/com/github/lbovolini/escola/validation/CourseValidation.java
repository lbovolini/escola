package com.github.lbovolini.escola.validation;

import com.github.lbovolini.escola.dto.CourseDTO;
import com.github.lbovolini.escola.exception.InvalidFormException;
import com.github.lbovolini.escola.message.InputError;

import java.util.ArrayList;
import java.util.List;

public class CourseValidation {

    public static void onCreate(CourseDTO courseDTO) {
        onCreate(courseDTO, new ArrayList<>());
    }

    private static void onCreate(CourseDTO courseDTO, List<InputError> errors) {

        String name = courseDTO.getName();
        if (name == null || name.isEmpty()) {
            errors.add(new InputError("name", "Name id required"));
        }

        if (!errors.isEmpty()) {
            throw new InvalidFormException(errors);
        }
    }

    public static void onUpdate(CourseDTO courseDTO) {
        List<InputError> errors = new ArrayList<>();

        int id = courseDTO.getId();
        if (id == 0) {
            errors.add(new InputError("id", "Id is required"));
        }

        onCreate(courseDTO, errors);
    }
}
