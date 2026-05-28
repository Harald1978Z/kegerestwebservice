package ru.z.kegerestwebservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.z.kegerestwebservice.entity.common.CommonEntity;
@Entity(name = "courses")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Courses extends CommonEntity<Long> {
    @Id
    private Long id;
    private String name;
}
