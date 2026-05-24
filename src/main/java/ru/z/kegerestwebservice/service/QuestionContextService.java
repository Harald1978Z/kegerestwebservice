package ru.z.kegerestwebservice.service;

import org.springframework.stereotype.Service;
import ru.z.kegerestwebservice.entity.QuestionContext;
import ru.z.kegerestwebservice.repository.QuestionContextRepository;
import ru.z.kegerestwebservice.service.common.CommonService;

import java.util.List;

@Service
public class QuestionContextService extends CommonService<QuestionContext, Long> {
    private final QuestionContextRepository questionContextRepository;
    public QuestionContextService(QuestionContextRepository questionContextRepository){
        super(questionContextRepository);
        this.questionContextRepository=questionContextRepository;
    }

    public List<QuestionContext> findQuestionContextRepositoryName(String fragment){
        return questionContextRepository.findQuestionContextByContent_type(fragment);
    }
}
