package ru.z.kegerestwebservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
public class CategoryContent extends CommonEntity<Long> {
    @Id
    private Long id;

    @Column(name = "category_id", nullable = false)
    private Long categoryId;

    @Lob
    @Column(columnDefinition = "bytea")
    private byte[] content;

    private String contentType;

    private String name;
}
