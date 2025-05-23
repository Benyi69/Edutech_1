package com.edu.edutech_1.controller;

import com.edu.edutech_1.service.AvisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/avisos")
public class AvisoController {
    @Autowired
    AvisoService avisoService;

    @GetMapping
    public String getAviso() {
        return avisoService.getAviso();
    }
    @GetMapping("/{id}")
    public String getAvisoById(@PathVariable Long id) {
        return avisoService.getAvisoById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAviso(@PathVariable Long id) {
        avisoService.deleteAviso(id);
    }

    @PostMapping
    public void saveAviso(@RequestBody String mensaje) {
        avisoService.saveAviso(mensaje);
    }

    @PostMapping("/{id}")
    public void updateAviso(@PathVariable Long id, @RequestBody String mensaje) {
        avisoService.updateAviso(id, mensaje);
    }


}
