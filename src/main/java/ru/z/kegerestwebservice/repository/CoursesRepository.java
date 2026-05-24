package ru.z.kegerestwebservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.z.kegerestwebservice.entity.Courses;

import java.util.List;

public interface CoursesRepository extends JpaRepository<Courses, Long> {
    List<Courses> findCoursesByName (String name);
}
