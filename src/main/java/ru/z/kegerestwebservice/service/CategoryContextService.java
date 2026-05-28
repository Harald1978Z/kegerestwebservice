package ru.z.kegerestwebservice.service;

import org.springframework.stereotype.Service;
import ru.z.kegerestwebservice.entity.CategoryContent;
import ru.z.kegerestwebservice.repository.CategoryContextRepository;
import ru.z.kegerestwebservice.service.common.CommonService;

import java.util.List;

@Service
public class CategoryContextService extends CommonService<CategoryContent, Long> {
    private final CategoryContextRepository categoryContextRepository;
    public CategoryContextService(CategoryContextRepository categoryContextRepository){
        super(categoryContextRepository);
        this.categoryContextRepository=categoryContextRepository;
    }

    public List<CategoryContent> findCategoryContextContainsName(String fragment){
        return categoryContextRepository.findCategoryContextByName(fragment);
    }
}
