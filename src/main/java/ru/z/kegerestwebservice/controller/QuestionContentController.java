package ru.z.kegerestwebservice.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.*;
import ru.z.kegerestwebservice.entity.QuestionContent;
import ru.z.kegerestwebservice.service.QuestionContentService;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(("question_content"))
@AllArgsConstructor
public class QuestionContentController {
    private final QuestionContentService contentService;

    // 1. Поиск всех строк в таблице
    @GetMapping
    public ResponseEntity<List<QuestionContent>> getAllContents() {
        log.info("REST request to get all question contents");
        List<QuestionContent> contents = contentService.getAll();
        return ResponseEntity.ok(contents);
    }

    // 2. Поиск одной строки по ID
    @GetMapping("/{id}")
    public ResponseEntity<QuestionContent> getContentById(@PathVariable Long id) {
        log.info("REST request to get question content by id: {}", id);
        QuestionContent content = contentService.getByIdOrThrow(id);
        return ResponseEntity.ok(content);
    }

    // 2a. Получение файла (бинарных данных) по ID
    @GetMapping("/{id}/download")
    public ResponseEntity<byte[]> downloadContent(@PathVariable Long id) {
        log.info("REST request to download content by id: {}", id);
        QuestionContent content = contentService.getByIdOrThrow(id);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(content.getContentType()));
        headers.setContentDispositionFormData("attachment", content.getName());

        return new ResponseEntity<>(content.getContent(), headers, HttpStatus.OK);
    }

    // 3. Поиск всех строк для одного вопроса по question_id
    @GetMapping("/question/{questionId}")
    public ResponseEntity<List<QuestionContent>> getContentsByQuestionId(@PathVariable Long questionId) {
        log.info("REST request to get question contents by question id: {}", questionId);
        List<QuestionContent> contents = contentService.findByQuestionId(questionId);
        return ResponseEntity.ok(contents);
    }

    // 4. Изменение строки (полное обновление через JSON)
    @PutMapping("/{id}")
    public ResponseEntity<QuestionContent> updateContent(
            @PathVariable Long id,
            @RequestBody QuestionContent updatedContent) {
        log.info("REST request to update question content with id: {}", id);
        QuestionContent content = contentService.update(id, updatedContent);
        return ResponseEntity.ok(content);
    }

    // 4a. Изменение строки через загрузку файла
    @PutMapping(value = "/{id}/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<QuestionContent> updateContentWithFile(
            @PathVariable Long id,
            @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "questionId", required = false) Long questionId) throws IOException {

        log.info("REST request to update question content with file, id: {}", id);
        QuestionContent content = contentService.updateWithFile(id, file, name, questionId);
        return ResponseEntity.ok(content);
    }

    // 5. Удаление строки
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContent(@PathVariable Long id) {
        log.info("REST request to delete question content by id: {}", id);
        contentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Дополнительные эндпоинты

    // Создание нового контента (через JSON)
    @PostMapping
    public ResponseEntity<QuestionContent> createContent(@RequestBody QuestionContent content) {
        log.info("REST request to create question content");
        QuestionContent savedContent = contentService.create(
                content.getContent(),
                content.getContentType(),
                content.getName(),
                content.getQuestionId()
        );
        return new ResponseEntity<>(savedContent, HttpStatus.CREATED);
    }

    // Создание нового контента (через загрузку файла)
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<QuestionContent> uploadContent(
            @RequestParam("file") MultipartFile file,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam("questionId") Long questionId) throws IOException {

        log.info("REST request to upload question content for question id: {}", questionId);
        QuestionContent content = contentService.createFromFile(file, name, questionId);
        return new ResponseEntity<>(content, HttpStatus.CREATED);
    }

    // Удаление всех контентов вопроса
    @DeleteMapping("/question/{questionId}")
    public ResponseEntity<Void> deleteContentsByQuestionId(@PathVariable Long questionId) {
        log.info("REST request to delete all question contents by question id: {}", questionId);
        contentService.deleteByQuestionId(questionId);
        return ResponseEntity.noContent().build();
    }
}
