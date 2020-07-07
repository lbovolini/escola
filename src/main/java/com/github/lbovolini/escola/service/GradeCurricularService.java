package com.github.lbovolini.escola.service;

import com.github.lbovolini.escola.dto.DisciplinaDTO;
import com.github.lbovolini.escola.dto.GradeCurricularDTO;
import com.github.lbovolini.escola.repository.GradeCurricularRepository;
import com.github.lbovolini.escola.repository.GradeCurricularRepositoryImpl;

import java.util.List;

public class GradeCurricularService {

    private GradeCurricularRepository gradeCurricularRepository;

    public GradeCurricularService() {
        this.gradeCurricularRepository = new GradeCurricularRepositoryImpl();
    }

    public void delete(int id) {
        gradeCurricularRepository.delete(id);
    }

    public GradeCurricularDTO find(int id) {
        return gradeCurricularRepository.find(id);
    }

    public List<DisciplinaDTO> findDisciplinas(int id) {
        return gradeCurricularRepository.findDisciplinas(id);
    }

    public void save(GradeCurricularDTO gradeCurricularDTO) {
        gradeCurricularRepository.save(gradeCurricularDTO);
    }

    public void update(GradeCurricularDTO gradeCurricularDTO) {
        gradeCurricularRepository.update(gradeCurricularDTO);
    }
}
