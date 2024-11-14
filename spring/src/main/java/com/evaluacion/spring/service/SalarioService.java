package com.evaluacion.spring.service;

import com.evaluacion.spring.model.Salario;

import java.util.List;

public interface SalarioService {
    public List<Salario> getAllSalarios() throws Exception;

    public Salario getSalarioById(Integer id) throws Exception;

    public Salario saveSalario(Salario salario) throws Exception;
}
