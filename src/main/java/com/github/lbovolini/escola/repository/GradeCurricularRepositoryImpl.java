package com.github.lbovolini.escola.repository;

import com.github.lbovolini.escola.dto.DisciplinaDTO;
import com.github.lbovolini.escola.dto.GradeCurricularDTO;
import com.github.lbovolini.escola.model.Disciplina;
import com.github.lbovolini.escola.model.GradeCurricular;
import com.github.lbovolini.escola.util.DisciplinaUtil;
import com.github.lbovolini.escola.util.GradeCurricularUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GradeCurricularRepositoryImpl extends RepositoryBase<GradeCurricular> implements GradeCurricularRepository {
    @Override
    public void delete(int id) {
        String query = "DELETE FROM GradeCurricular WHERE id = ?1";

        List parameters = new ArrayList();
        parameters.add(id);

        executeDelete(query, parameters);
    }

    @Override
    public GradeCurricularDTO find(int id) {
        String query = "SELECT g FROM GradeCurricular g WHERE g.id = ?1";

        List parameters = new ArrayList();
        parameters.add(id);

        GradeCurricular gradeCurricular = (GradeCurricular)executeSingle(query, parameters);

        return GradeCurricularUtil.toDTO(gradeCurricular);
    }

    @Override
    public List<DisciplinaDTO> findDisciplinas(int id) {
        String query = "SELECT d FROM Disciplina d JOIN DisciplinaGradeCurricular dgc ON d.id = dgc.disciplineId JOIN GradeCurricular g ON g.id = dgc.curriculumId WHERE g.id = ?1";

        List parameters = new ArrayList();
        parameters.add(id);

        List<Disciplina> disciplinaList = execute(query, parameters);
        List<DisciplinaDTO> disciplinaDTOList = disciplinaList.stream().map(DisciplinaUtil::toDTO).collect(Collectors.toList());

        return disciplinaDTOList;
    }

    @Override
    public void save(GradeCurricularDTO gradeCurricularDTO) {
        GradeCurricular gradeCurricular = GradeCurricularUtil.toModel(gradeCurricularDTO);
        super.save(gradeCurricular);
    }

    @Override
    public void update(GradeCurricularDTO gradeCurricularDTO) {
        GradeCurricularDTO gradeCurricularDTO1 = find(gradeCurricularDTO.getId());

        if (gradeCurricularDTO1 == null) {
            return;
        }

        GradeCurricular gradeCurricular = GradeCurricularUtil.toModel(gradeCurricularDTO);
        super.update(gradeCurricular);
    }
}
