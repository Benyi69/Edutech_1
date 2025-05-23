package com.edu.edutech_1.controller;

import com.edu.edutech_1.model.Alumno;
import com.edu.edutech_1.model.Contenido;
import com.edu.edutech_1.model.Curso;
import com.edu.edutech_1.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cursos")
public class CursoController {

    @Autowired
    CursoService cursoService;

    //Primero los cursos

    @GetMapping
    public ResponseEntity<List<Curso>> getCursos() {
        List<Curso> cursos = cursoService.getCursos();
        if (cursos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cursos);
    }

    @PostMapping
    public ResponseEntity<Curso> addCurso(@RequestBody Curso curso) {
        Curso creado = cursoService.addCurso(curso);
        return ResponseEntity.status(201).body(creado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCursoById(@PathVariable int id) {
        return cursoService.getCursoById(id)
                .<ResponseEntity<Object>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404).body("Curso no encontrado"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCurso(@PathVariable int id) {
        boolean deleted = cursoService.deleteCurso(id);
        if (deleted) {
            return ResponseEntity.ok("Curso eliminado");
        }
        return ResponseEntity.status(404).body("Curso no encontrado");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCurso(@RequestBody Curso curso, @PathVariable int id) {
        boolean updated = cursoService.updateCurso(id, curso);
        if (updated) {
            return ResponseEntity.ok("Curso actualizado");
        }
        return ResponseEntity.status(404).body("Curso no encontrado");
    }

// Alumnos

    @GetMapping("/{idCurso}/alumnos")
    public ResponseEntity<List<Alumno>> getAlumnos(@PathVariable int idCurso) {
        List<Alumno> alumnos = cursoService.getAlumnos(idCurso);
        if (alumnos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(alumnos);
    }

    @DeleteMapping("/{idCurso}/alumnos/{id}")
    public ResponseEntity<String> deleteAlumno(@PathVariable int idCurso, @PathVariable int id) {
        boolean deleted = cursoService.deleteAlumno(idCurso, id);
        if (deleted) {
            return ResponseEntity.ok("Alumno eliminado");
        }
        return ResponseEntity.status(404).body("Alumno no encontrado");
    }

    @PostMapping("/{idCurso}/alumnos")
    public ResponseEntity<String> addAlumno(@PathVariable int idCurso, @RequestBody Alumno alumno) {
        boolean added = cursoService.addAlumno(idCurso, alumno);
        if (added) {
            return ResponseEntity.status(201).body("Alumno agregado");
        }
        return ResponseEntity.status(404).body("Curso no encontrado");
    }

// Contenidos

    @GetMapping("/{idCurso}/contenidos")
    public ResponseEntity<List<Contenido>> getContenidos(@PathVariable int idCurso) {
        List<Contenido> contenidos = cursoService.getContenidos(idCurso);
        if (contenidos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(contenidos);
    }

    @DeleteMapping("/{idCurso}/contenidos/{id}")
    public ResponseEntity<String> deleteContenido(@PathVariable int idCurso, @PathVariable int id) {
        boolean deleted = cursoService.deleteContenido(idCurso, id);
        if (deleted) {
            return ResponseEntity.ok("Contenido eliminado");
        }
        return ResponseEntity.status(404).body("Contenido no encontrado");
    }

    @PostMapping("/{idCurso}/contenidos")
    public ResponseEntity<String> addContenido(@PathVariable int idCurso, @RequestBody Contenido contenido) {
        boolean added = cursoService.addContenido(idCurso, contenido);
        if (added) {
            return ResponseEntity.status(201).body("Contenido agregado");
        }
        return ResponseEntity.status(404).body("Curso no encontrado");
    }

}
