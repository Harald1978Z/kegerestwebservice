package ru.z.kegerestwebservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.z.kegerestwebservice.entity.CategoryContent;
import ru.z.kegerestwebservice.service.CategoryContextService;

import java.util.List;

@RestController
@RequestMapping(("category_context"))
@AllArgsConstructor
public class CategoryContextController {
    private final CategoryContextService categoryContextService;

    @GetMapping
    public List<CategoryContent> getAllCategoryContext(){
        return categoryContextService.getAll();
    }
    @GetMapping("/by_name/{fragment}")
    public List<CategoryContent> getCategoryContextByName(@PathVariable String name){
        return categoryContextService.findCategoryContextContainsName(name);
    }
    @GetMapping("/id/{id}")
    public CategoryContent getCategoryContextById(@PathVariable Long id){
        return categoryContextService.getById(id);
    }
    @PostMapping("/save_categoryContext")
    public CategoryContent saveCategoryContext(@RequestBody CategoryContent categoryContext){
        return categoryContextService.save(categoryContext);
    }
    @DeleteMapping("/delete_categoryContext")
    public String deleteCategoryContext(@RequestBody CategoryContent categoryContext){
        return categoryContextService.delete(categoryContext);
    }
}
