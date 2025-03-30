package com.rollerspeed.rollerspeed.controller;

import com.rollerspeed.rollerspeed.model.Instructor;
import com.rollerspeed.rollerspeed.service.InstructorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/instructors")
@Tag(name = "Instructores", description = "Operaciones relacionadas con instructores")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @Operation(summary = "Obtener todos los instructores", description = "Retorna una lista de todos los instructores")
    @GetMapping
    public String listInstructors(Model model) {
        List<Instructor> instructors = instructorService.getAllInstructors();
        model.addAttribute("instructors", instructors);
        return "instructors/list";
    }

    @Operation(summary = "Mostrar formulario de registro", description = "Muestra el formulario para registrar un nuevo instructor")
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("instructor", new Instructor());
        return "instructors/register";
    }

    @Operation(summary = "Registrar un nuevo instructor", description = "Registra un nuevo instructor en el sistema")
    @PostMapping("/register")
    public String registerInstructor(@ModelAttribute Instructor instructor) {
        instructorService.saveInstructor(instructor);
        return "redirect:/instructors";
    }

    @Operation(summary = "Mostrar formulario de edición", description = "Muestra el formulario para editar un instructor existente")
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Instructor instructor = instructorService.findById(id);
        if (instructor == null) {
            return "redirect:/instructors"; 
        }
        model.addAttribute("instructor", instructor);
        return "instructors/edit"; 
    }

    @Operation(summary = "Actualizar un instructor", description = "Actualiza los datos de un instructor existente")
    @PostMapping("/edit/{id}")
    public String updateInstructor(@PathVariable Long id, @ModelAttribute Instructor instructor) {
        instructorService.updateInstructor(id, instructor);
        return "redirect:/instructors";
    }

    @Operation(summary = "Eliminar un instructor", description = "Eliminar un instructor")
    @DeleteMapping("/delete/{id}")
    public String deleteInstructor(@PathVariable Long id) {
        instructorService.deleteInstructor(id);
        return "redirect:/instructors";
    }
}
