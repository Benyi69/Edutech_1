package com.edu.edutech_1.controller;

import com.edu.edutech_1.model.CuponDescuento;
import com.edu.edutech_1.service.CuponDescuentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cupones-descuento")
public class CuponDescuentoController {

    @Autowired
    private CuponDescuentoService cuponDescuentoService;

    @GetMapping
    public ResponseEntity<List<CuponDescuento>> getCuponesDescuento() {
        List<CuponDescuento> cupones = cuponDescuentoService.getCuponesDescuento();
        if (cupones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cupones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCuponDescuentoById(@PathVariable int id) {
        return cuponDescuentoService.getCuponDescuentoById(id)
                .<ResponseEntity<Object>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404).body("Cupon no encontrado"));
    }

    @PostMapping
    public ResponseEntity<CuponDescuento> addCuponDescuento(@RequestBody CuponDescuento cuponDescuento) {
        CuponDescuento creado = cuponDescuentoService.addCuponDescuento(cuponDescuento);
        return ResponseEntity.status(201).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCuponDescuento(@PathVariable int id, @RequestBody CuponDescuento cuponDescuento) {
        boolean updated = cuponDescuentoService.updateCuponDescuento(id, cuponDescuento);
        if (updated) {
            return ResponseEntity.ok("Cupon actualizado");
        }
        return ResponseEntity.status(404).body("Cupon no encontrado");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCuponDescuento(@PathVariable int id) {
        boolean deleted = cuponDescuentoService.deleteCuponDescuento(id);
        if (deleted) {
            return ResponseEntity.ok("Cupon eliminado");
        }
        return ResponseEntity.status(404).body("Cupon no encontrado");
    }
}
