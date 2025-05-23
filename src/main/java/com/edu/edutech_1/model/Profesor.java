package com.edu.edutech_1.model;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString(callSuper = true)
public class Profesor extends Usuario {

}
