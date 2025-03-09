package com.rollerspeed.rollerspeed.model;

import java.sql.Date;

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
}
