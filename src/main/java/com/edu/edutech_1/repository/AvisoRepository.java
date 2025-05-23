package com.edu.edutech_1.repository;

import com.edu.edutech_1.model.Aviso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface AvisoRepository extends JpaRepository<Aviso, Integer> {
}
