package com.rollerspeed.rollerspeed.controller;

import com.rollerspeed.rollerspeed.model.Instructor;
import com.rollerspeed.rollerspeed.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/instructors")
public class InstructorController {

    @Autowired
    private InstructorRepository instructorRepository;

    @GetMapping
    public String listInstructors(Model model) {
        List<Instructor> instructors = instructorRepository.findAll();
        model.addAttribute("instructors", instructors);
        return "instructors/list";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("instructor", new Instructor());
        return "instructors/register";
    }

    @PostMapping("/register")
    public String registerInstructor(@ModelAttribute Instructor instructor) {
        instructorRepository.save(instructor);
        return "redirect:/instructors";
    }

    @PostMapping("/delete/{id}")
    public String deleteInstructor(@PathVariable Long id) {
        instructorRepository.deleteById(id);
        return "redirect:/instructors";
    }
}
