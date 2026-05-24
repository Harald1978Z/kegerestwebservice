package ru.z.kegerestwebservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ru.z.kegerestwebservice.entity.CategoryContext;

import java.util.List;

@Service
public interface CategoryContextRepository extends JpaRepository<CategoryContext, Long> {
    List<CategoryContext> findCategoryContextByName(String name);
}
