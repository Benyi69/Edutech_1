package com.edu.edutech_1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    @ManyToOne(optional = true)
    @JoinColumn(name = "id_profesor",nullable = true)
    private Profesor profesor;

    private List<Alumno> listaalumno;


}
