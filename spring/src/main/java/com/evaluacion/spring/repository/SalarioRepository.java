package com.evaluacion.spring.repository;

import com.evaluacion.spring.model.Salario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SalarioRepository extends JpaRepository<Salario, Integer> {
    Optional<Salario> findByIdPuesto(Integer idPuesto);
}