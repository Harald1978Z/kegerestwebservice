package ru.z.kegerestwebservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import ru.z.kegerestwebservice.entity.QuestionContent;

import java.util.List;

public interface QuestionContentRepository extends JpaRepository<QuestionContent, Long> {
    // Поиск всех записей для конкретного вопроса
    List<QuestionContent> findByQuestionId(Long questionId);

    // Удаление всех записей для конкретного вопроса
    @Modifying
    @Transactional
    void deleteByQuestionId(Long questionId);

    // Проверка существования контента у вопроса
    boolean existsByQuestionId(Long questionId);

    // Поиск по имени файла (дополнительный метод)
    List<QuestionContent> findByNameContainingIgnoreCase(String name);

    // Поиск по типу контента
    List<QuestionContent> findByContentType(String contentType);
}
