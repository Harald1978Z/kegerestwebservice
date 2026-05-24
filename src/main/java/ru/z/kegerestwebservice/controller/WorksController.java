package ru.z.kegerestwebservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.z.kegerestwebservice.entity.Works;
import ru.z.kegerestwebservice.service.WorksService;

import java.util.List;

@RestController
@RequestMapping(("works"))
@AllArgsConstructor
public class WorksController {
    private final WorksService worksService;

    @GetMapping
    public List<Works> getAllWorks(){
        return worksService.getAll();
    }
    @GetMapping("/by_name/{fragment}")
    public List<Works> getWorksByName(@PathVariable String fragment){
        return worksService.findWorksByName(fragment);
    }
    @GetMapping("/id/{id}")
    public Works getWorksById(@PathVariable Long id){
        return worksService.getById(id);
    }
    @PostMapping("/save_works")
    public Works saveWorks(@RequestBody Works works){
        return worksService.save(works);
    }
    @DeleteMapping("/delete_works")
    public String deleteWorks(@RequestBody Works works){
        return worksService.delete(works);
    }
}
