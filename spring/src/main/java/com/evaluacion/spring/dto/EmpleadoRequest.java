package com.evaluacion.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoRequest {
    private String idEmpleado;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String sexo;
    private Date fNacimiento;
    private String telCelular;
    private int idPuesto;
    private String usuario;
    private String idUsuario;
    private String password;
    private char activo;
}
