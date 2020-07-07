package com.github.lbovolini.escola.repository;

import com.github.lbovolini.escola.dto.DisciplinaDTO;
import com.github.lbovolini.escola.dto.GradeCurricularDTO;

import java.util.List;

public interface GradeCurricularRepository {

    void delete(int id);

    GradeCurricularDTO find(int id);

    List<DisciplinaDTO> findDisciplinas(int id);

    void save(GradeCurricularDTO gradeCurricularDTO);

    void update(GradeCurricularDTO gradeCurricularDTO);
}
