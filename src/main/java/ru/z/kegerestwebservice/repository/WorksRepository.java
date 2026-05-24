package ru.z.kegerestwebservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.z.kegerestwebservice.entity.Works;

import java.util.List;

public interface WorksRepository extends JpaRepository<Works, Long> {
    List<Works> findWorksByName (String name);
}
