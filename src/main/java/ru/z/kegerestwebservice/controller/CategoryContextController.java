package ru.z.kegerestwebservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.z.kegerestwebservice.entity.CategoryContext;
import ru.z.kegerestwebservice.service.CategoryContextService;

import java.util.List;

@RestController
@RequestMapping(("categoty_context"))
@AllArgsConstructor
public class CategoryContextController {
    private final CategoryContextService categoryContextService;

    @GetMapping
    public List<CategoryContext> getAllCategoryContext(){
        return categoryContextService.getAll();
    }
    @GetMapping("/by_name/{fragment}")
    public List<CategoryContext> getCategoryContextByName(@PathVariable String name){
        return categoryContextService.findCategoryContextContainsName(name);
    }
    @GetMapping("/id/{id}")
    public CategoryContext getCategoryContextById(@PathVariable Long id){
        return categoryContextService.getById(id);
    }
    @PostMapping("/save_categoryContext")
    public CategoryContext saveCategoryContext(@RequestBody CategoryContext categoryContext){
        return categoryContextService.save(categoryContext);
    }
    @DeleteMapping("/delete_categoryContext")
    public String deleteCategoryContext(@RequestBody CategoryContext categoryContext){
        return categoryContextService.delete(categoryContext);
    }
}
