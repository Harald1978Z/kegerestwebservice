package ru.z.kegerestwebservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.z.kegerestwebservice.entity.StudentWorks;
import ru.z.kegerestwebservice.service.StudentWorksService;

import java.util.List;

@RestController
@RequestMapping(("student_works"))
@AllArgsConstructor
public class StudentWorksController {
    private final StudentWorksService studentWorksService;

    @GetMapping
    public List<StudentWorks> getAllStudentWorks(){
        return studentWorksService.getAll();
    }
    @GetMapping("/by_name/{fragment}")
    public List<StudentWorks> getStudentWorksByAnswer(@PathVariable String fragment){
        return studentWorksService.findStudentWorksByAnswer_text(fragment);
    }
    @GetMapping("/id/{id}")
    public StudentWorks getStudentWorksById(@PathVariable Long id){
        return studentWorksService.getById(id);
    }
    @PostMapping("/save_studentWorks")
    public StudentWorks saveStudentWorks(@RequestBody StudentWorks studentWorks){
        return studentWorksService.save(studentWorks);
    }
    @DeleteMapping("/delete_studentWorks")
    public String deleteStudentWorks(@RequestBody StudentWorks studentWorks){
        return studentWorksService.delete(studentWorks);
    }
}
