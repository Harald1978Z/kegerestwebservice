package ru.z.kegerestwebservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.z.kegerestwebservice.entity.Questions;
import ru.z.kegerestwebservice.service.QuestionsService;

import java.util.List;

@RestController
@RequestMapping(("questions"))
@AllArgsConstructor
public class QuestionsController {
    private final QuestionsService questionsService;

    @GetMapping
    public List<Questions> getAllQuestions(){
        return questionsService.getAll();
    }
    @GetMapping("/by_name/{fragment}")
    public List<Questions> getQuestionsByAnswer(@PathVariable String fragment){
        return questionsService.findQuestionsRepositoryName(fragment);
    }
    @GetMapping("/id/{id}")
    public Questions getQuestionsById(@PathVariable Long id){
        return questionsService.getById(id);
    }
    @PostMapping("/save_questions")
    public Questions saveQuestions(@RequestBody Questions questions){
        return questionsService.save(questions);
    }
    @DeleteMapping("/delete_questions")
    public String deleteQuestions(@RequestBody Questions questions){
        return questionsService.delete(questions);
    }
}
