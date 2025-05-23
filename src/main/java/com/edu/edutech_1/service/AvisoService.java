package com.edu.edutech_1.service;

import com.edu.edutech_1.repository.AvisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvisoService {
    @Autowired
    AvisoRepository avisoRepository;

    public void saveAviso(String mensaje){
        return avisoRepository.saveAviso(mensaje);
    }
    public String getAviso(){
        return avisoRepository.getAviso();
    }
    public void deleteAviso(){
        avisoRepository.deleteAviso();
    }
    public void updateAviso(String mensaje){
        avisoRepository.updateAviso(mensaje);
    }
}
