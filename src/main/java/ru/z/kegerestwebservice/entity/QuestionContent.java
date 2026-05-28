package ru.z.kegerestwebservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.z.kegerestwebservice.entity.common.CommonEntity;

@Entity(name = "question_content")
@AllArgsConstructor
@Builder
@Data
public class QuestionContent extends CommonEntity<Long> {
    @Id
    private Long id;

    @Lob
    @Column(columnDefinition = "bytea")
    private byte[] content;

    @Column(name = "content_type")
    private String contentType;
    private String name;

    @Column(name = "question_id", nullable = false)
    private Long questionId;

    public QuestionContent(byte[] content, String contentType, String name, Long questionId) {
    }

    public QuestionContent() {
    }
}
