package ru.z.kegerestwebservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.z.kegerestwebservice.entity.WorkQuestions;
import ru.z.kegerestwebservice.service.WorkQuestionsService;

import java.util.List;

@RestController
@RequestMapping(("work_question"))
@AllArgsConstructor
public class WorkQuestionsController {
    private final WorkQuestionsService workQuestionsService;

    @GetMapping
    public List<WorkQuestions> getAllWorkQuestions(){
        return workQuestionsService.getAll();
    }

    @GetMapping("/id/{id}")
    public WorkQuestions getWorkQuestionsById(@PathVariable Long id){
        return workQuestionsService.getById(id);
    }
    @PostMapping("/save_workQuestions")
    public WorkQuestions saveWorkQuestions(@RequestBody WorkQuestions workQuestions){
        return workQuestionsService.save(workQuestions);
    }
    @DeleteMapping("/delete_workQuestions")
    public String deleteWorkQuestions(@RequestBody WorkQuestions workQuestions){
        return workQuestionsService.delete(workQuestions);
    }
}
