package com.evaluacion.spring.service.impl;

import com.evaluacion.spring.model.Salario;
import com.evaluacion.spring.repository.SalarioRepository;
import com.evaluacion.spring.service.SalarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalarioServiceImpl implements SalarioService {

    @Autowired
    private SalarioRepository salarioRepository;

    public List<Salario> getAllSalarios() {
        return salarioRepository.findAll();
    }

    public Salario getSalarioById(Integer id) {
        return salarioRepository.findById(id).orElse(null);
    }

    public Salario saveSalario(Salario salario) {
        return salarioRepository.save(salario);
    }
}
