package com.edu.edutech_1.service;

import com.edu.edutech_1.model.Contenido;
import com.edu.edutech_1.repository.ContenidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class ContenidoService {
    @Autowired
    private ContenidoRepository contenidoRepository;

    public List<Contenido> getContenidos() {
        return contenidoRepository.findAll();
    }

    public Optional<Contenido> getContenidoById(int id) {
        return contenidoRepository.findById(id);
    }

    public Contenido addContenido(Contenido contenido) {
        return contenidoRepository.save(contenido);
    }

    public boolean updateContenido(int id, Contenido contenido) {
        if (contenidoRepository.existsById(id)) {
            contenido.setId(id);
            contenidoRepository.save(contenido);
            return true;
        }
        return false;
    }

    public boolean deleteContenido(int id) {
        if (contenidoRepository.existsById(id)) {
            contenidoRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
