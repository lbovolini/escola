package com.github.lbovolini.escola.config;

import com.github.lbovolini.escola.repository.*;
import com.github.lbovolini.escola.service.*;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class DependencyBinder extends AbstractBinder {

    @Override
    protected void configure() {
        // Service
        bind(StudentService.class).to(StudentService.class);
        bind(AuthenticationService.class).to(AuthenticationService.class);
        bind(CourseService.class).to(CourseService.class);
        bind(DisciplineService.class).to(DisciplineService.class);
        bind(CurriculumService.class).to(CurriculumService.class);
        bind(TeacherService.class).to(TeacherService.class);
        bind(GroupService.class).to(GroupService.class);
        // Repository
        bind(StudentRepositoryImpl.class).to(StudentRepository.class);
        bind(CourseRepositoryImpl.class).to(CourseRepository.class);
        bind(DisciplineRepositoryImpl.class).to(DisciplineRepository.class);
        bind(CurriculumRepositoryImpl.class).to(CurriculumRepository.class);
        bind(TeacherRepositoryImpl.class).to(TeacherRepository.class);
        bind(GroupRepositoryImpl.class).to(GroupRepository.class);
    }
}
