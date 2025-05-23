package com.edu.edutech_1.repository;

import com.edu.edutech_1.model.Soporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoporteRepository extends JpaRepository <Soporte, Integer>{
}
