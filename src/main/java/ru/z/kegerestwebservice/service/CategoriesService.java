package ru.z.kegerestwebservice.service;

import org.springframework.stereotype.Service;
import ru.z.kegerestwebservice.entity.Categories;
import ru.z.kegerestwebservice.repository.CategoriesRepository;
import ru.z.kegerestwebservice.service.common.CommonService;

import java.util.List;

@Service
public class CategoriesService extends CommonService<Categories, Long> {
    private final CategoriesRepository categoriesRepository;
    public CategoriesService(CategoriesRepository categoriesRepository){
        super(categoriesRepository);
        this.categoriesRepository=categoriesRepository;
    }

    public List<Categories> findCategoriesContainsName(String fragment){
        return categoriesRepository.findCategoriesByName(fragment);
    }
}
