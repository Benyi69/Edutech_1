package com.edu.edutech_1.service;

import com.edu.edutech_1.model.CuponDescuento;
import com.edu.edutech_1.repository.CuponDescuentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CuponDescuentoService {
    @Autowired
    private CuponDescuentoRepository cuponDescuentoRepository;

    public List<CuponDescuento> getCuponesDescuento() {
        return cuponDescuentoRepository.findAll();
    }

    public Optional<CuponDescuento> getCuponDescuentoById(int id) {
        return cuponDescuentoRepository.findById(id);
    }

    public CuponDescuento addCuponDescuento(CuponDescuento cuponDescuento) {
        return cuponDescuentoRepository.save(cuponDescuento);
    }

    public boolean updateCuponDescuento(int id, CuponDescuento cuponDescuento) {
        if (cuponDescuentoRepository.existsById(id)) {
            cuponDescuento.setId(id);
            cuponDescuentoRepository.save(cuponDescuento);
            return true;
        }
        return false;
    }

    public boolean deleteCuponDescuento(int id) {
        if (cuponDescuentoRepository.existsById(id)) {
            cuponDescuentoRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
