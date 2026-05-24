package ru.z.kegerestwebservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.z.kegerestwebservice.entity.QuestionContext;
import ru.z.kegerestwebservice.service.QuestionContextService;

import java.util.List;

@RestController
@RequestMapping(("question_context"))
@AllArgsConstructor
public class QuestionContextController {
    private final QuestionContextService questionContextService;
    @GetMapping
    public List<QuestionContext> getAllQuestionContext(){
        return questionContextService.getAll();
    }
    @GetMapping("/by_name/{fragment}")
    public List<QuestionContext> getQuestionContextByContextType(@PathVariable String fragment){
        return questionContextService.findQuestionContextRepositoryName(fragment);
    }
    @GetMapping("/id/{id}")
    public QuestionContext getQuestionContextById(@PathVariable Long id){
        return questionContextService.getById(id);
    }
    @PostMapping("/save_questionContext")
    public QuestionContext saveQuestionContext(@RequestBody QuestionContext questionContext){
        return questionContextService.save(questionContext);
    }
    @DeleteMapping("/delete_questionContext")
    public String deleteQuestionContext(@RequestBody QuestionContext questionContext){
        return questionContextService.delete(questionContext);
    }
}
