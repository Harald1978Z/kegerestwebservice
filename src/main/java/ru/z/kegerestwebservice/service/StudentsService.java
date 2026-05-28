package ru.z.kegerestwebservice.service;

import org.springframework.stereotype.Service;
import ru.z.kegerestwebservice.entity.Students;
import ru.z.kegerestwebservice.repository.StudentsRepository;
import ru.z.kegerestwebservice.service.common.CommonService;

import java.util.List;

@Service
public class StudentsService extends CommonService<Students, Long> {
    private final StudentsRepository studentsRepository;
    public StudentsService(StudentsRepository studentsRepository){
        super(studentsRepository);
        this.studentsRepository=studentsRepository;
    }

    public List<Students> findStudentsByFirst_nameAndLast_name(String fragment, String fragment1){
        return studentsRepository.findStudentsByFirstNameAndLastName(fragment,fragment1);
    }
}
