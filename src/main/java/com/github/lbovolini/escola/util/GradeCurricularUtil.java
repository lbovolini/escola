package com.github.lbovolini.escola.util;

import com.github.lbovolini.escola.dto.GradeCurricularDTO;
import com.github.lbovolini.escola.model.GradeCurricular;

public class GradeCurricularUtil {

    public static GradeCurricularDTO toDTO(GradeCurricular gradeCurricular) {
        GradeCurricularDTO gradeCurricularDTO = new GradeCurricularDTO();
        gradeCurricularDTO.setId(gradeCurricular.getId());
        gradeCurricularDTO.setYear(gradeCurricular.getYear());
        gradeCurricularDTO.setCourseId(gradeCurricular.getCourseId());

        return gradeCurricularDTO;
    }

    public static GradeCurricular toModel(GradeCurricularDTO gradeCurricularDTO) {
        GradeCurricular gradeCurricular = new GradeCurricular();
        gradeCurricular.setId(gradeCurricularDTO.getId());
        gradeCurricular.setYear(gradeCurricularDTO.getYear());
        gradeCurricular.setCourseId(gradeCurricularDTO.getCourseId());

        return gradeCurricular;
    }
}
