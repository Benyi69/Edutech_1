package com.edu.edutech_1.controller;

import com.edu.edutech_1.service.SoporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/soporte")
public class SoporteController {
    @Autowired
    private SoporteService soporteService;

    @GetMapping
    public String getSoporte() {
        return "Soporte";
    }

    @PostMapping
    public String createSoporte() {
        return "Crear Soporte";
    }

    @GetMapping("/{id}")
    public String getSoporteById(Long id) {
        return "Soporte con ID: " + id;
    }

    @DeleteMapping("/{id}")
    public String deleteSoporteById(Long id) {
        return "Soporte con ID: " + id + " eliminado";
    }

    @PutMapping("/{id}")
    public String updateSoporteById(Long id) {
        return "Soporte con ID: " + id + " actualizado";
    }
}
