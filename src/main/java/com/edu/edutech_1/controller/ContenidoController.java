package com.edu.edutech_1.controller;

import com.edu.edutech_1.model.Contenido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contenidos")
public class ContenidoController {

    @Autowired
    ContenidoController contenidoController;

    @GetMapping
    public ResponseEntity<List<Contenido>> getContenidos() {
        return contenidoController.getContenidos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contenido> getContenidoById(@PathVariable Integer id) {
        return contenidoController.getContenidoById(id);
    }

    @PostMapping
    public ResponseEntity<Contenido> addContenido(@RequestBody Contenido contenido) {
        return contenidoController.addContenido(contenido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contenido> updateContenido(@PathVariable Integer id, @RequestBody Contenido contenido) {
        return contenidoController.updateContenido(id, contenido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContenido(@PathVariable Integer id) {
        return contenidoController.deleteContenido(id);
    }
}
