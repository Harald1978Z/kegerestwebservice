package ru.z.kegerestwebservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.z.kegerestwebservice.entity.Students;
import ru.z.kegerestwebservice.service.StudentsService;

import java.util.List;

@RestController
@RequestMapping(("students"))
@AllArgsConstructor
public class StudentsController {
    private final StudentsService studentsService;

    @GetMapping
    public List<Students> getAllStudents(){
        return studentsService.getAll();
    }
    @GetMapping("/by_name/{fragment}")
    public List<Students> getStudentsByFirstAndLastName(@PathVariable String fragment, @PathVariable String lastName){
        return studentsService.findStudentsByFirst_nameAndLast_name(fragment, lastName);
    }
    @GetMapping("/id/{id}")
    public Students getStudentsById(@PathVariable Long id){
        return studentsService.getById(id);
    }
    @PostMapping("/save_students")
    public Students saveStudents(@RequestBody Students students){
        return studentsService.save(students);
    }
    @DeleteMapping("/delete_students")
    public String deleteStudents(@RequestBody Students students){
        return studentsService.delete(students);
    }
}
