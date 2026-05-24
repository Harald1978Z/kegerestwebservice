package ru.z.kegerestwebservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.z.kegerestwebservice.entity.StudentWorks;

import java.util.List;

public interface StudentWorksRepository extends JpaRepository<StudentWorks, Long> {
    List<StudentWorks> findStudentWorksByAnswer_text (String answer);
}
