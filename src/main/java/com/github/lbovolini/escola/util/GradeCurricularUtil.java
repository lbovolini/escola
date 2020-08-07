package com.github.lbovolini.escola.util;

import com.github.lbovolini.escola.dto.CursoDTO;
import com.github.lbovolini.escola.dto.GradeCurricularDTO;
import com.github.lbovolini.escola.model.Curso;
import com.github.lbovolini.escola.model.GradeCurricular;

public class GradeCurricularUtil {

    public static GradeCurricularDTO toDTO(GradeCurricular gradeCurricular) {
        GradeCurricularDTO gradeCurricularDTO = new GradeCurricularDTO();
        gradeCurricularDTO.setId(gradeCurricular.getId());
        gradeCurricularDTO.setYear(gradeCurricular.getYear());
        gradeCurricularDTO.setCursoDTO(CursoUtil.toDTO(gradeCurricular.getCurso()));

        return gradeCurricularDTO;
    }

    public static GradeCurricular toModel(GradeCurricularDTO gradeCurricularDTO) {
        GradeCurricular gradeCurricular = new GradeCurricular();
        gradeCurricular.setId(gradeCurricularDTO.getId());
        gradeCurricular.setYear(gradeCurricularDTO.getYear());
        gradeCurricular.setCurso(new Curso(gradeCurricularDTO.getCursoDTO().getId()));

        return gradeCurricular;
    }
}
