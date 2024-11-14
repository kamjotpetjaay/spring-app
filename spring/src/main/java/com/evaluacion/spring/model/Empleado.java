package com.evaluacion.spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {
    @Id
    @Column(name = "id_empleado")
    private String idEmpleado;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido1")
    private String apellido1;
    @Column(name = "apellido2")
    private String apellido2;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "f_nacimiento")
    private Date fNacimiento;
    @Column(name = "tel_celular")
    private String telCelular;
    @Column(name = "id_puesto")
    private Integer idPuesto;
    /*@ManyToOne
    @JoinColumn(name = "idPuesto", nullable = false)
    private Salario salario;*/
    @Transient
    private char activo;
}
