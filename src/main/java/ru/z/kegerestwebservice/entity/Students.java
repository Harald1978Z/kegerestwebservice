package ru.z.kegerestwebservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.z.kegerestwebservice.entity.common.CommonEntity;
@Entity(name = "students")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Students implements CommonEntity<Long> {
    @Id
    private Long id;
    private String first_name;
    private String last_name;
    private String middle_name;
}
