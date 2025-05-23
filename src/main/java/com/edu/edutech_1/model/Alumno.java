package com.edu.edutech_1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
@PrimaryKeyJoinColumn(name = "id")

public class Alumno extends Usuario {
    @ManyToMany(mappedBy = "listaalumno")
    private List<Alumno> alumnos = new ArrayList<>();
}
