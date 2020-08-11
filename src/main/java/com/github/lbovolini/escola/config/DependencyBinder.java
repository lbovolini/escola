package com.github.lbovolini.escola.config;

import com.github.lbovolini.escola.repository.*;
import com.github.lbovolini.escola.service.*;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class DependencyBinder extends AbstractBinder {

    @Override
    protected void configure() {
        // Service
        bind(AlunoService.class).to(AlunoService.class);
        bind(AuthenticationService.class).to(AuthenticationService.class);
        bind(CursoService.class).to(CursoService.class);
        bind(DisciplinaService.class).to(DisciplinaService.class);
        bind(GradeCurricularService.class).to(GradeCurricularService.class);
        bind(ProfessorService.class).to(ProfessorService.class);
        bind(TurmaService.class).to(TurmaService.class);
        // Repository
        bind(AlunoRepositoryImpl.class).to(AlunoRepository.class);
        bind(CursoRepositoryImpl.class).to(CursoRepository.class);
        bind(DisciplinaRepositoryImpl.class).to(DisciplinaRepository.class);
        bind(GradeCurricularRepositoryImpl.class).to(GradeCurricularRepository.class);
        bind(ProfessorRepositoryImpl.class).to(ProfessorRepository.class);
        bind(TurmaRepositoryImpl.class).to(TurmaRepository.class);
    }
}
