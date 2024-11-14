package com.evaluacion.spring.service;

import com.evaluacion.spring.dto.EmpleadoDTO;
import com.evaluacion.spring.dto.EmpleadoRequest;
import com.evaluacion.spring.model.Empleado;

import java.util.List;

public interface EmpleadoService {

    public List<Empleado> getAllEmpleados() throws Exception;

    public Empleado getEmpleadoById(String id) throws Exception;

    public Empleado saveEmpleado(EmpleadoRequest empleado) throws Exception;

    List<EmpleadoDTO> obtenerEmpleadosConActivo();

    List<EmpleadoDTO> findEmpleadosBySexo(String sexo);

    void actualizarEmpleados(List<Empleado> empleados);

    void eliminarEmpleado(String idEmpleado);
}