package ru.z.kegerestwebservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.z.kegerestwebservice.entity.Categories;
import ru.z.kegerestwebservice.service.CategoriesService;

import java.util.List;

@RestController
@RequestMapping(("categories"))
@AllArgsConstructor
public class CategoriesController {
    private final CategoriesService categoriesService;

    @GetMapping
    public List<Categories> getAllCategories(){
        return categoriesService.getAll();
    }
    @GetMapping("/by_name/{fragment}")
    public List<Categories> getCategoriesByName(@PathVariable String fragment){
        return categoriesService.findCategoriesContainsName(fragment);
    }
    @GetMapping("/id/{id}")
    public Categories getCategoriesById(@PathVariable Long id){
        return categoriesService.getById(id);
    }
    @PostMapping("/save_categories")
    public Categories saveCategories(@RequestBody Categories categories){
        return categoriesService.save(categories);
    }
    @DeleteMapping("/delete_categories")
    public String deleteCategories(@RequestBody Categories categories){
        return categoriesService.delete(categories);
    }
}
