package ru.z.kegerestwebservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.z.kegerestwebservice.entity.common.CommonEntity;
@Entity(name = "work_question")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class WorkQuestions extends CommonEntity<Long> {
    @Id
    private Long id;
    private Long workId;
    private Long questionId;
}
