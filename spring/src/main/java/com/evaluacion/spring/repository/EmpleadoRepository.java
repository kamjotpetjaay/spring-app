package com.evaluacion.spring.repository;

import com.evaluacion.spring.dto.EmpleadoDTO;
import com.evaluacion.spring.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, String> {
    @Query("SELECT new com.evaluacion.spring.dto.EmpleadoDTO(e.idEmpleado, e.nombre, e.apellido1, e.apellido2, e.sexo, e.fNacimiento, e.telCelular, sa.salario, s.activo, sa.descripcion, s.usuario) " +
            "FROM Empleado e " +
            "LEFT JOIN Salario sa ON e.idPuesto = sa.idPuesto "+
            "LEFT JOIN Seguridad s ON e.idEmpleado = s.idEmpleado")
    List<EmpleadoDTO> findAllWithActivo();
    List<Empleado> findBySexo(String sexo);
}