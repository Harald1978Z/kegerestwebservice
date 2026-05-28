package ru.z.kegerestwebservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.z.kegerestwebservice.entity.common.CommonEntity;
@Entity(name = "question")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Questions extends CommonEntity<Long> {
    @Id
    private Long id;
    private Long courseId;
    private Long categoryId;
    private String questionText;
    private String answerText;
    private String descriptions;
}
