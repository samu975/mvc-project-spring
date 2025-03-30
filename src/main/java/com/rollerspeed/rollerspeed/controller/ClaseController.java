package com.rollerspeed.rollerspeed.controller;

import com.rollerspeed.rollerspeed.model.Clase;
import com.rollerspeed.rollerspeed.model.Instructor;
import com.rollerspeed.rollerspeed.model.Student;
import com.rollerspeed.rollerspeed.service.ClaseService;
import com.rollerspeed.rollerspeed.service.InstructorService;
import com.rollerspeed.rollerspeed.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

        Clase clase = new Clase();
        model.addAttribute("clase", clase);

        List<Instructor> instructores = instructorService.getAllInstructors();
        /* List<Student> students = studentService.getAllStudents(); */
        model.addAttribute("instructores", instructores);

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
        Clase clase = claseService.findById(id);
        if (clase == null) {
            return "redirect:/clases";
        }

        if (clase.getInstructor() != null) {
            Hibernate.initialize(clase.getInstructor());
        }

        model.addAttribute("clase", clase);
        model.addAttribute("instructores", instructorService.getAllInstructors());

        return "clases/edit";
    }

    @Operation(summary = "Actualizar una clase existente", description = "Actualiza los datos de una clase en el sistema")
    @PostMapping("/editar/{id}")
    public String actualizarClase(
            @PathVariable Long id,
            @ModelAttribute("clase") Clase clase,
            @RequestParam("instructor.id") Long instructorId,
            BindingResult result) {

        if (result.hasErrors()) {
            return "clases/edit";
        }

        Clase claseExistente = claseService.findById(id);
        if (claseExistente == null) {
            return "redirect:/clases";
        }

        // Actualizar campos básicos
        claseExistente.setHorario(clase.getHorario());
        claseExistente.setNivel(clase.getNivel());

        // Asignar instructor
        Instructor instructor = instructorService.findById(instructorId);
        claseExistente.setInstructor(instructor);

        claseService.save(claseExistente);
        return "redirect:/clases";
    }

    @Operation(summary = "Eliminar una clase", description = "Elimina una clase del aplicativo")
    @DeleteMapping("/delete/{id}")
    public String deleteClase(@PathVariable Long id) {
        claseService.deleteClase(id);
        return "redirect:/clases";
    }
}