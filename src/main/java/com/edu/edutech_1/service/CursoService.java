package com.edu.edutech_1.service;

import com.edu.edutech_1.model.Alumno;
import com.edu.edutech_1.model.Contenido;
import com.edu.edutech_1.model.Curso;
import com.edu.edutech_1.repository.AlumnoRepository;
import com.edu.edutech_1.repository.ContenidoRepository;
import com.edu.edutech_1.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
     @Autowired
    CursoRepository cursoRepository;

     @Autowired
    AlumnoRepository alumnoRepository;

     @Autowired
     ContenidoRepository contenidoRepository;



    public List<Curso> getCursos() {
        return cursoRepository.findAll();
    }

    public Curso saveCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Curso getCursoById(int id) {
        return cursoRepository.findById(id).orElse(null);
    }

    public boolean deleteCurso(int id) {
        if (cursoRepository.existsById(id)) {
            cursoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Curso updateCurso(Curso curso, int id) {
        if (cursoRepository.existsById(id)) {
            curso.setId(id);
            return cursoRepository.save(curso);
        }
        return null;
    }

    // Alumnos

    public List<Alumno> getAlumnos(int idCurso) {
        Optional<Curso> cursoOpt = cursoRepository.findById(idCurso);
        return cursoOpt.map(Curso::getListaCurso).orElse(null);
    }

    public boolean addAlumno(int idCurso, int idAlumno) {
        Optional<Curso> cursoOpt = cursoRepository.findById(idCurso);
        Optional<Alumno> alumnoOpt = alumnoRepository.findById(idAlumno);
        if (cursoOpt.isPresent() && alumnoOpt.isPresent()) {
            Curso curso = cursoOpt.get();
            Alumno alumno = alumnoOpt.get();
            curso.addAlumno(alumno);
            cursoRepository.save(curso);
            return true;
        }
        return false;
    }

    public boolean deleteAlumno(int idCurso, int idAlumno) {
        Optional<Curso> cursoOpt = cursoRepository.findById(idCurso);
        if (cursoOpt.isPresent()) {
            Curso curso = cursoOpt.get();
            Optional<Alumno> alumnoOpt = curso.getListaCurso().stream()
                    .filter(a -> a.getId() == idAlumno)
                    .findFirst();
            if (alumnoOpt.isPresent()) {
                curso.removeAlumno(alumnoOpt.get());
                cursoRepository.save(curso);
                return true;
            }
        }
        return false;
    }

    // Contenidos

    public List<Contenido> getContenidos(int idCurso) {
        Optional<Curso> cursoOpt = cursoRepository.findById(idCurso);
        return cursoOpt.map(Curso::getListaContenido).orElse(null);
    }

    public boolean addContenido(int idCurso, int idContenido) {
        Optional<Curso> cursoOpt = cursoRepository.findById(idCurso);
        Optional<Contenido> contenidoOpt = contenidoRepository.findById(idContenido);
        if (cursoOpt.isPresent() && contenidoOpt.isPresent()) {
            Curso curso = cursoOpt.get();
            Contenido contenido = contenidoOpt.get();
            curso.addContenido(contenido);
            cursoRepository.save(curso);
            return true;
        }
        return false;
    }

    public boolean deleteContenido(int idCurso, int idContenido) {
        Optional<Curso> cursoOpt = cursoRepository.findById(idCurso);
        if (cursoOpt.isPresent()) {
            Curso curso = cursoOpt.get();
            Optional<Contenido> contenidoOpt = curso.getListaContenido().stream()
                    .filter(c -> c.getId() == idContenido)
                    .findFirst();
            if (contenidoOpt.isPresent()) {
                curso.removeContenido(contenidoOpt.get());
                cursoRepository.save(curso);
                return true;
            }
        }
        return false;
    }


}
