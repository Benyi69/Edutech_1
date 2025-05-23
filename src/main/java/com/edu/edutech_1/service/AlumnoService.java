package com.edu.edutech_1.service;

import com.edu.edutech_1.model.Alumno;
import com.edu.edutech_1.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {
    @Autowired
    AlumnoRepository alumnoRepsitory;

    @Autowired
    private AlumnoRepository alumnoRepository;

    public List<Alumno> getAlumnos() {
        return alumnoRepository.findAll();
    }

    public Alumno saveAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    public Alumno getAlumnoById(int id) {
        return alumnoRepository.findById(id).orElse(null);
    }

    public void deleteAlumno(int id) {
        alumnoRepository.deleteById(id);
    }

    public Alumno updateAlumno(int id, Alumno newAlumno) {
        Optional<Alumno> alumnoOpt = alumnoRepository.findById(id);
        if (alumnoOpt.isPresent()) {
            Alumno alumno = alumnoOpt.get();
            alumno.setNombre(newAlumno.getNombre());
            alumno.setRut(newAlumno.getRut());
            alumno.setDv(newAlumno.getDv());
            alumno.setCorreo(newAlumno.getCorreo());
            return alumnoRepository.save(alumno);
        }
        return null;
    }
}
