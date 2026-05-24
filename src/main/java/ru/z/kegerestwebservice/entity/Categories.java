package ru.z.kegerestwebservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.z.kegerestwebservice.entity.common.CommonEntity;
@Entity(name = "categories")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Categories implements CommonEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int category_id;
    private int content;
    private String content_type;
    private String name;
}
