package ru.z.kegerestwebservice.service;

import org.springframework.stereotype.Service;
import ru.z.kegerestwebservice.entity.WorkQuestions;
import ru.z.kegerestwebservice.repository.WorkQuestionsRepository;
import ru.z.kegerestwebservice.service.common.CommonService;

import java.util.List;

@Service
public class WorkQuestionsService extends CommonService<WorkQuestions, Long> {
    private final WorkQuestionsRepository workQuestionsRepository;
    public WorkQuestionsService(WorkQuestionsRepository workQuestionsRepository){
        super(workQuestionsRepository);
        this.workQuestionsRepository=workQuestionsRepository;
    }

    public List<WorkQuestions> findWorkQuestionsById(Long fragment){
        return workQuestionsRepository.findWorkQuestionsById(fragment);
    }
}
