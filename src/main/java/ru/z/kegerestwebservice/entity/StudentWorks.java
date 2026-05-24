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
public class StudentWorks implements CommonEntity<Long> {
    @Id
    private Long id;
    private int student_id;
    private int work_id;
    private int question_id;
    private Date work_date;
    private String answer_text;
}
