package com.adrian.springboot_jparelationships.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adrian.springboot_jparelationships.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


}
