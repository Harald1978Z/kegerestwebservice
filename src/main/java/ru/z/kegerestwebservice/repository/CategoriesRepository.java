package ru.z.kegerestwebservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.z.kegerestwebservice.entity.Categories;

import java.util.List;

public interface CategoriesRepository extends JpaRepository<Categories, Long> {
    List<Categories> findCategoriesByName(String name);
}
