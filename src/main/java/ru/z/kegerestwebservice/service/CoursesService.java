package ru.z.kegerestwebservice.service;

import org.springframework.stereotype.Service;
import ru.z.kegerestwebservice.entity.Courses;
import ru.z.kegerestwebservice.repository.CoursesRepository;
import ru.z.kegerestwebservice.service.common.CommonService;

import java.util.List;

@Service
public class CoursesService extends CommonService<Courses, Long>{
    private final CoursesRepository coursesRepository;
    public CoursesService(CoursesRepository coursesRepository){
        super(coursesRepository);
        this.coursesRepository=coursesRepository;
    }

    public List<Courses> findCoursesContainsName(String fragment){
        return coursesRepository.findCoursesByName(fragment);
    }
}
