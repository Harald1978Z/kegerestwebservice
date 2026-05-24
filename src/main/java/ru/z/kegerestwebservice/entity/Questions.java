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
public class Questions implements CommonEntity<Long> {
    @Id
    private Long id;
    private int course_id;
    private int category_id;
    private String question_text;
    private String Answer_text;
    private String descriptions;
}
