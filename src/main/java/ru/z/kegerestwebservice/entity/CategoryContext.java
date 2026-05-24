package ru.z.kegerestwebservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.z.kegerestwebservice.entity.common.CommonEntity;
@Entity(name = "category_context")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CategoryContext implements CommonEntity<Long> {
    @Id
    private Long id;
    private String theory;
    private String name;
}
