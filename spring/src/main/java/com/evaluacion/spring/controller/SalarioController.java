package com.evaluacion.spring.controller;


import com.evaluacion.spring.model.Salario;
import com.evaluacion.spring.service.SalarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/salarios")
public class SalarioController {

    @Autowired
    private SalarioService salarioService;

    @GetMapping
    public List<Salario> getAllSalarios() throws Exception {
        return salarioService.getAllSalarios();
    }
}
