package com.adrian.springboot_jparelationships.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.adrian.springboot_jparelationships.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select s from Student s left join fetch s.courses where s.id = ?1")
    Optional<Student> findOneWithCourses(Long id);


}
