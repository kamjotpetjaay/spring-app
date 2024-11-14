package com.evaluacion.spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Salario {
    @Id
    private Integer idPuesto;
    private String descripcion;
    private BigDecimal salario;
}