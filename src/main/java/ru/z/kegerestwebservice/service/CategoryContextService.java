package ru.z.kegerestwebservice.service;

import org.springframework.stereotype.Service;
import ru.z.kegerestwebservice.entity.CategoryContext;
import ru.z.kegerestwebservice.repository.CategoryContextRepository;
import ru.z.kegerestwebservice.service.common.CommonService;

import java.util.List;

@Service
public class CategoryContextService extends CommonService<CategoryContext, Long> {
    private final CategoryContextRepository categoryContextRepository;
    public CategoryContextService(CategoryContextRepository categoryContextRepository){
        super(categoryContextRepository);
        this.categoryContextRepository=categoryContextRepository;
    }

    public List<CategoryContext> findCategoryContextContainsName(String fragment){
        return categoryContextRepository.findCategoryContextByName(fragment);
    }
}
