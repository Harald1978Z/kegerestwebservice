package ru.z.kegerestwebservice.service;

import org.springframework.stereotype.Service;
import ru.z.kegerestwebservice.entity.StudentWorks;
import ru.z.kegerestwebservice.repository.StudentWorksRepository;
import ru.z.kegerestwebservice.service.common.CommonService;

import java.util.List;

@Service
public class StudentWorksService extends CommonService<StudentWorks, Long> {
    private final StudentWorksRepository studentWorksRepository;
    public StudentWorksService(StudentWorksRepository studentWorksRepository){
        super(studentWorksRepository);
        this.studentWorksRepository=studentWorksRepository;
    }

    public List<StudentWorks> findStudentWorksByAnswer_text(String fragment){
        return studentWorksRepository.findStudentWorksByAnswerText(fragment);
    }
}
