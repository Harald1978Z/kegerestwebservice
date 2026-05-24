package ru.z.kegerestwebservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.z.kegerestwebservice.entity.WorkQuestions;

import java.util.List;

public interface WorkQuestionsRepository extends JpaRepository<WorkQuestions, Long> {
    List<WorkQuestions> findWorkQuestionsById (Long id);
}
