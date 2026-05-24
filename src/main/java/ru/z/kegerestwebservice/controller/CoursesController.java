package ru.z.kegerestwebservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.z.kegerestwebservice.entity.Courses;
import ru.z.kegerestwebservice.service.CoursesService;

import java.util.List;

@RestController
@RequestMapping(("courses"))
@AllArgsConstructor
public class CoursesController {
    private final CoursesService coursesService;

    @GetMapping
    public List<Courses> getAllCourses(){
        return coursesService.getAll();
    }
    @GetMapping("/by_name/{fragment}")
    public List<Courses> getCoursesByName(@PathVariable String fragment){
        return coursesService.findCoursesContainsName(fragment);
    }
    @GetMapping("/id/{id}")
    public Courses getCoursesById(@PathVariable Long id){
        return coursesService.getById(id);
    }
    @PostMapping("/save_courses")
    public Courses saveCourses(@RequestBody Courses courses){
        return coursesService.save(courses);
    }
    @DeleteMapping("/delete_courses")
    public String deleteCourses(@RequestBody Courses courses){
        return coursesService.delete(courses);
    }
}
