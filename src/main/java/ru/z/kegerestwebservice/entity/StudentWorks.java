package ru.z.kegerestwebservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.z.kegerestwebservice.entity.common.CommonEntity;

import java.util.Date;

@Entity(name = "student_works")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class StudentWorks extends CommonEntity<Long> {
    @Id
    private Long id;
    private Long studentId;
    private Long workId;
    private Long questionId;
    private Date workDate;
    private String answerText;
}
