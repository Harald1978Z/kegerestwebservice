package ru.z.kegerestwebservice.service;

import org.springframework.stereotype.Service;
import ru.z.kegerestwebservice.entity.Questions;
import ru.z.kegerestwebservice.repository.QuestionsRepository;
import ru.z.kegerestwebservice.service.common.CommonService;

import java.util.List;

@Service
public class QuestionsService extends CommonService<Questions, Long> {
    private final QuestionsRepository questionsRepository;
    public QuestionsService(QuestionsRepository questionsRepository){
        super(questionsRepository);
        this.questionsRepository=questionsRepository;
    }

    public List<Questions> findQuestionsRepositoryName(String fragment){
        return questionsRepository.findQuestionsByQuestion_text(fragment);
    }
}
