package com.rollerspeed.rollerspeed.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
    private String nombre;
    private Date fechaNacimiento;
    private String genero;
    private String correo;
    private String telefono;
    private String metodoPago;

    @ManyToMany(mappedBy = "estudiantes")
    private List<Clase> clases;

}
