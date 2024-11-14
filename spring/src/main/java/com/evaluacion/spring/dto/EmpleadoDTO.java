package com.evaluacion.spring.dto;

import com.evaluacion.spring.model.Salario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class EmpleadoDTO {
    private String idEmpleado;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String sexo;
    Date fNacimiento;
    private String telCelular;
    //private Integer idPuesto;
    private BigDecimal salario;
    private char activo;
    private String puesto;
    private String usuario;


    // Constructor
    public EmpleadoDTO(String idEmpleado, String nombre, String apellido1, String apellido2, String sexo,
                       Date fNacimiento, String telCelular, BigDecimal salario, char activo, String puesto, String usuario) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.sexo = sexo;
        this.fNacimiento = fNacimiento;
        this.telCelular = telCelular;
        //this.idPuesto = idPuesto;
        this.salario = salario;
        this.activo = activo;
        this.puesto = puesto;
        this.usuario = usuario;
    }
}
