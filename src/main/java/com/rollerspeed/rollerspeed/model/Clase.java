package com.rollerspeed.rollerspeed.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Entity
@Table(name = "clases")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Clase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime horario;
    private String nivel;

      @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @ManyToMany
    @JoinTable(
        name = "clase_alumno",
        joinColumns = @JoinColumn(name = "clase_id"),
        inverseJoinColumns = @JoinColumn(name = "alumno_id"))
    private List<Student> estudiantes;
}


