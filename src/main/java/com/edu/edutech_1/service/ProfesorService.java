package com.edu.edutech_1.service;

import com.edu.edutech_1.model.Profesor;
import com.edu.edutech_1.repository.ProfesorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProfesorService {
    @Autowired
     ProfesorRepository profesorRepository;

    public List<Profesor> getProfesores() {
        return profesorRepository.findAll();
    }

    public Profesor getProfesorById(Integer id) {
        return profesorRepository.findById(id).get();
    }

    public Profesor saveProfesor(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    public ResponseEntity<Profesor> updateProfesor(Integer id, Profesor profesor) {
        if (profesorRepository.existsById(id)) {
            profesor.setId(id);
            return ResponseEntity.ok(profesorRepository.save(profesor));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public void deleteProfesor(Integer id) {
        profesorRepository.deleteById(id);
    }

}
