package com.edu.edutech_1.controller;


import com.edu.edutech_1.model.Profesor;
import com.edu.edutech_1.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/profesores")
public class ProfesorController {
    @Autowired
    ProfesorService profesorService;

    @GetMapping
    public List<Profesor> getProfesores() {
        return profesorService.getProfesores();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Profesor> getProfesorById(@PathVariable Integer id) {
        Profesor profesor = profesorService.getProfesorById(id);
        if (profesor != null) {
            return ResponseEntity.ok(profesor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Profesor> createProfesor(@RequestBody Profesor profesor) {
        Profesor savedProfesor = profesorService.saveProfesor(profesor);
        return ResponseEntity.status(201).body(savedProfesor);
    }

    @DeleteMapping("/{id}")
    public void deleteProfesor(@PathVariable Integer id) {
        profesorService.deleteProfesor(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profesor> updateProfesor(@PathVariable Integer id, @RequestBody Profesor profesor) {
        return profesorService.updateProfesor(id, profesor);
    }



}
