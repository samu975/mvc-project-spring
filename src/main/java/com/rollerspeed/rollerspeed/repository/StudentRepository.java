package com.rollerspeed.rollerspeed.repository;

import com.rollerspeed.rollerspeed.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
  
}
