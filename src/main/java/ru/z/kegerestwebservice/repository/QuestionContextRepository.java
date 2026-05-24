package ru.z.kegerestwebservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.z.kegerestwebservice.entity.QuestionContext;

import java.util.List;

public interface QuestionContextRepository extends JpaRepository<QuestionContext, Long> {
    List<QuestionContext> findQuestionContextByContent_type (String contentType);
}
