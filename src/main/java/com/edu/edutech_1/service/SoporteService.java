package com.edu.edutech_1.service;

import com.edu.edutech_1.model.Soporte;
import com.edu.edutech_1.repository.SoporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoporteService {

    @Autowired
    private SoporteRepository soporteRepository;

    public void saveSoporte(Soporte soporte) {
        soporteRepository.save(soporte);
    }

    public Soporte getSoporteById(Long id) {
        return soporteRepository.findById(id).orElse(null);
    }

    public void deleteSoporte(Long id) {
        soporteRepository.deleteById(id);
    }

    public List<Soporte> getAllSoportes() {
        return soporteRepository.findAll();
    }
}
