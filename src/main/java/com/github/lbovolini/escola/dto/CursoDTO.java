package com.github.lbovolini.escola.dto;

public class CursoDTO {

    private int id;
    private String name;
    private GradeCurricularDTO gradeCurricularDTO;

    public CursoDTO() {
    }

    public CursoDTO(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GradeCurricularDTO getGradeCurricularDTO() {
        return gradeCurricularDTO;
    }

    public void setGradeCurricularDTO(GradeCurricularDTO gradeCurricularDTO) {
        this.gradeCurricularDTO = gradeCurricularDTO;
    }
}
