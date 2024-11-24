package com.adrian.springboot_jparelationships.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adrian.springboot_jparelationships.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
