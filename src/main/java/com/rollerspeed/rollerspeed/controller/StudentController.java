package com.rollerspeed.rollerspeed.controller;

import com.rollerspeed.rollerspeed.model.Student;
import com.rollerspeed.rollerspeed.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/students")
@Tag(name = "Estudiantes", description = "Operaciones relacionadas con estudiantes")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Operation(summary = "Obtener todos los estudiantes", description = "Retorna una lista de todos los estudiantes")
    @GetMapping
    public String listStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "students/list";
    }

    @Operation(summary = "Mostrar formulario de registro", description = "Muestra el formulario para registrar un nuevo estudiante")
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("student", new Student());
        return "students/register";
    }

    @Operation(summary = "Registrar un nuevo estudiante", description = "Registra un nuevo estudiante en el sistema")
    @PostMapping("/register")
    public String registerStudent(@ModelAttribute Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }
    @Operation(summary = "Eliminar un estudiante", description = "Eliminar un estudiante del sistema")
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    return "redirect:/students";
}
}
