package ru.z.kegerestwebservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.z.kegerestwebservice.entity.QuestionContent;
import ru.z.kegerestwebservice.repository.QuestionContentRepository;
import ru.z.kegerestwebservice.service.common.CommonService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
@Transactional
public class QuestionContentService extends CommonService<QuestionContent, Long> {
    private final QuestionContentRepository questionContentRepository;

    @Autowired
    public QuestionContentService(QuestionContentRepository questionContentRepository) {
        super(questionContentRepository);
        this.questionContentRepository = questionContentRepository;
    }

    // 1. Поиск всех строк (переопределяем для кастомной логики если нужно)
    @Override
    public List<QuestionContent> getAll() {
        log.info("Getting all question contents");
        return super.getAll();
    }

    // 2. Поиск одной строки по ID (используем родительский метод)

    // 3. Поиск всех строк для одного вопроса по question_id
    public List<QuestionContent> findByQuestionId(Long questionId) {
        log.info("Finding question contents by question id: {}", questionId);
        return questionContentRepository.findByQuestionId(questionId);
    }

    // 4. Изменение строки (полное обновление)
    public QuestionContent update(Long id, QuestionContent updatedContent) {
        log.info("Updating question content with id: {}", id);
        QuestionContent existingContent = getById(id);
        if (existingContent == null) {
            log.error("Question content not found with id: {}", id);
            throw new RuntimeException("Content not found with id: " + id);
        }

        if (updatedContent.getContent() != null) {
            existingContent.setContent(updatedContent.getContent());
        }
        if (updatedContent.getContentType() != null) {
            existingContent.setContentType(updatedContent.getContentType());
        }
        if (updatedContent.getName() != null) {
            existingContent.setName(updatedContent.getName());
        }
        if (updatedContent.getQuestionId() != null) {
            existingContent.setQuestionId(updatedContent.getQuestionId());
        }

        return save(existingContent);
    }

    // 4a. Обновление через MultipartFile
    public QuestionContent updateWithFile(Long id, MultipartFile file, String name, Long questionId) throws IOException {
        log.info("Updating question content with file, id: {}", id);
        QuestionContent existingContent = getById(id);
        if (existingContent == null) {
            throw new RuntimeException("Content not found with id: " + id);
        }

        if (file != null && !file.isEmpty()) {
            existingContent.setContent(file.getBytes());
            existingContent.setContentType(file.getContentType());
        }
        if (name != null && !name.isEmpty()) {
            existingContent.setName(name);
        }
        if (questionId != null) {
            existingContent.setQuestionId(questionId);
        }

        return save(existingContent);
    }

    // 5. Удаление строки (используем родительский метод deleteById)

    // Дополнительные методы

    // Создание нового контента
    public QuestionContent create(byte[] content, String contentType, String name, Long questionId) {
        log.info("Creating new question content for question id: {}", questionId);
        QuestionContent newContent = new QuestionContent(content, contentType, name, questionId);
        return save(newContent);
    }

    // Создание из MultipartFile
    public QuestionContent createFromFile(MultipartFile file, String name, Long questionId) throws IOException {
        log.info("Creating new question content from file for question id: {}", questionId);
        QuestionContent newContent = new QuestionContent(
                file.getBytes(),
                file.getContentType(),
                name != null ? name : file.getOriginalFilename(),
                questionId
        );
        return save(newContent);
    }

    // Удаление всех контентов вопроса
    @Transactional
    public void deleteByQuestionId(Long questionId) {
        log.info("Deleting all question contents for question id: {}", questionId);
        if (questionContentRepository.existsByQuestionId(questionId)) {
            questionContentRepository.deleteByQuestionId(questionId);
        }
    }

    // Получение с проверкой существования
    public QuestionContent getByIdOrThrow(Long id) {
        QuestionContent content = getById(id);
        if (content == null) {
            throw new RuntimeException("Question content not found with id: " + id);
        }
        return content;
    }
}
