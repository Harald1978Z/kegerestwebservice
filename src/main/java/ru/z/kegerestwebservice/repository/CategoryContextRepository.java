package ru.z.kegerestwebservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ru.z.kegerestwebservice.entity.CategoryContent;

import java.util.List;

@Service
public interface CategoryContextRepository extends JpaRepository<CategoryContent, Long> {
    List<CategoryContent> findCategoryContextByName(String name);
}
