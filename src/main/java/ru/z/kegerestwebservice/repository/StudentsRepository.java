package ru.z.kegerestwebservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.z.kegerestwebservice.entity.Students;

import java.util.List;

public interface StudentsRepository extends JpaRepository<Students, Long> {
    List<Students> findStudentsByFirstNameAndLastName (String firstName, String lastName);
}
