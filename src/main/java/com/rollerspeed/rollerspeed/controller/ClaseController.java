package com.rollerspeed.rollerspeed.controller;

import com.rollerspeed.rollerspeed.model.Clase;
import com.rollerspeed.rollerspeed.model.Instructor;
import com.rollerspeed.rollerspeed.model.Student;
import com.rollerspeed.rollerspeed.service.ClaseService;
import com.rollerspeed.rollerspeed.service.InstructorService;
import com.rollerspeed.rollerspeed.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clases")
@Tag(name = "Clases", description = "Operaciones relacionadas con clases")

public class ClaseController {

    @Autowired
    private ClaseService claseService;

    @Autowired
    private InstructorService instructorService;

    @Autowired
    private StudentService studentService;

    @Operation(summary = "Obtener todas las clases", description = "Retorna una lista de todos las clases")
    @GetMapping
    public String listarClases(Model model) {
        model.addAttribute("clases", claseService.findAll());
        return "clases/lista";
    }

    @Operation(summary = "Mostrar formulario de clases", description = "Muestra el formulario para crear una nueva clase")
    @GetMapping("/nuevo")
    public String mostrarFormularioClase(Model model) {
        // Crear una nueva instancia de Clase
        Clase clase = new Clase();
        model.addAttribute("clase", clase);

        // Obtener la lista de instructores y estudiantes para el formulario
        List<Instructor> instructores = instructorService.getAllInstructors();
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("instructores", instructores);
        model.addAttribute("students", students);

        return "clases/formulario";
    }

    @Operation(summary = "Registrar una nueva clase", description = "Registra una nueva clase en el aplicativo")
    @PostMapping("/guardar")
    public String guardarClase(@ModelAttribute Clase clase) {
        claseService.save(clase);
        return "redirect:/clases";
    }

    @GetMapping("/editar/{id}")
    public String editarClase(@PathVariable Long id, Model model) {
        // Obtener la clase por ID
        Clase clase = claseService.findById(id);
        model.addAttribute("clase", clase);

        // Obtener la lista de instructores y estudiantes para el formulario
        List<Instructor> instructores = instructorService.getAllInstructors();
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("instructores", instructores);
        model.addAttribute("students", students);

        return "clases/formulario";
    }

    @Operation(summary = "Eliminar una clase", description = "Elimina una clase del aplicativo")
    @DeleteMapping("/delete/{id}")
    public String deleteClase(@PathVariable Long id) {
        claseService.deleteClase(id);
        return "redirect:/clases";
    }
}