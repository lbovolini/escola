package com.github.lbovolini.escola.util;

import com.github.lbovolini.escola.dto.CurriculumDTO;
import com.github.lbovolini.escola.model.Curriculum;

public class CurriculumUtil {

    public static CurriculumDTO toDTO(Curriculum curriculum) {
        CurriculumDTO curriculumDTO = new CurriculumDTO();
        curriculumDTO.setId(curriculum.getId());
        curriculumDTO.setYear(curriculum.getYear());
        curriculumDTO.setCourseId(curriculum.getCourseId());

        return curriculumDTO;
    }

    public static Curriculum toModel(CurriculumDTO curriculumDTO) {
        Curriculum curriculum = new Curriculum();
        curriculum.setId(curriculumDTO.getId());
        curriculum.setYear(curriculumDTO.getYear());
        curriculum.setCourseId(curriculumDTO.getCourseId());

        return curriculum;
    }
}
