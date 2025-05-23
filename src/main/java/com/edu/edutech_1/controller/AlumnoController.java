package com.edu.edutech_1.controller;

import com.edu.edutech_1.model.Alumno;
import com.edu.edutech_1.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/alumnos")
public class AlumnoController {

    @Autowired
    AlumnoController alumnoController;

    @GetMapping
    public ResponseEntity<List<Alumno>> getAlumnos() {
        return alumnoController.getAlumnos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> getAlumnoById(@PathVariable Long id) {
        return alumnoController.getAlumnoById(id);
    }

    @PostMapping
    public ResponseEntity<Alumno> addAlumno(@RequestBody Alumno alumno) {
        return alumnoController.addAlumno(alumno);
    }


}
