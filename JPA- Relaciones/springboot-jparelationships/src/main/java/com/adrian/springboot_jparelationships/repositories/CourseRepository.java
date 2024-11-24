package com.adrian.springboot_jparelationships.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.adrian.springboot_jparelationships.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("select c from Course c left join fetch c.students where c.id=?1")
    Optional<Course> findOneWithStudents(Long id);
}
