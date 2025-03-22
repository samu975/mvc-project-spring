package com.rollerspeed.rollerspeed.controller;

import com.rollerspeed.rollerspeed.model.Clase;
import com.rollerspeed.rollerspeed.model.Instructor;
import com.rollerspeed.rollerspeed.model.Student;
import com.rollerspeed.rollerspeed.service.ClaseService;
import com.rollerspeed.rollerspeed.service.InstructorService;
import com.rollerspeed.rollerspeed.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clases")
public class ClaseController {

    @Autowired
    private ClaseService claseService;

    @Autowired
    private InstructorService instructorService;

    @Autowired
    private StudentService studentService;

    @GetMapping
    public String listarClases(Model model) {
        model.addAttribute("clases", claseService.findAll());
        return "clases/lista";
    }

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

    @DeleteMapping("/delete/{id}")
    public String deleteClase(@PathVariable Long id) {
        claseService.deleteClase(id);
        return "redirect:/clases";
    }
}