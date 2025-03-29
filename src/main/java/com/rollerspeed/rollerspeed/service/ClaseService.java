package com.rollerspeed.rollerspeed.service;

import com.rollerspeed.rollerspeed.model.Clase;
import com.rollerspeed.rollerspeed.model.Instructor;
import com.rollerspeed.rollerspeed.model.Student;
import com.rollerspeed.rollerspeed.repository.ClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaseService {

    @Autowired
    private ClaseRepository claseRepository;

    public List<Clase> findAll() {
        return claseRepository.findAll();
    }

    public Clase save(Clase clase) {
        return claseRepository.save(clase);
    }

    public Clase findById(Long id) {
        return claseRepository.findById(id).orElse(null);
    }

    
    public Clase updateClase(Long id, Clase claseDetails) {
        Clase clase = findById(id);
        
        // Actualizar campos básicos
        clase.setHorario(claseDetails.getHorario());
        clase.setNivel(claseDetails.getNivel());
        clase.setInstructor(claseDetails.getInstructor());
        
        
        return claseRepository.save(clase);
    }

    

    public void deleteClase(Long id) {
        claseRepository.deleteById(id);
    }
}