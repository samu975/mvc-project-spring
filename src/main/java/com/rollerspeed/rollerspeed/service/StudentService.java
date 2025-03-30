package com.rollerspeed.rollerspeed.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.rollerspeed.rollerspeed.model.Instructor;
import com.rollerspeed.rollerspeed.model.Student;
import com.rollerspeed.rollerspeed.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    
  @Autowired
  private StudentRepository studentRepository;

  public List<Student> getAllStudents() {
    return studentRepository.findAll();
  }

  public Student saveStudent(Student student) {
    return studentRepository.save(student);
  }

  public Student findById(Long id) {
    return studentRepository.findById(id).orElse(null);
}

  public void deleteStudent(Long id) {
    studentRepository.deleteById(id);
  }
public Student updateStudent(Long id, Student student) {
        Student existingStudent = findById(id);
        if (existingStudent != null) {
            existingStudent.setNombre(student.getNombre());
            existingStudent.setCorreo(student.getCorreo());
            existingStudent.setCorreo(student.getGenero());
            existingStudent.setCorreo(student.getMetodoPago());
            existingStudent.setTelefono(student.getTelefono());            
            existingStudent.setFechaNacimiento(student.getFechaNacimiento());
            return studentRepository.save(existingStudent);
        }
        return null;
    }

}