package com.rollerspeed.rollerspeed.service;

import com.rollerspeed.rollerspeed.model.Instructor;
import com.rollerspeed.rollerspeed.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {
    @Autowired
    private InstructorRepository instructorRepository;

    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    public Instructor saveInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    public Instructor findById(Long id) {
        return instructorRepository.findById(id).orElse(null);
    }
    
    public void deleteInstructor(Long id) {
        instructorRepository.deleteById(id);
    }
}