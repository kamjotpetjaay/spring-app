package com.evaluacion.spring.service.impl;

import com.evaluacion.spring.dto.EmpleadoDTO;
import com.evaluacion.spring.dto.EmpleadoRequest;
import com.evaluacion.spring.model.Empleado;
import com.evaluacion.spring.model.Salario;
import com.evaluacion.spring.model.Seguridad;
import com.evaluacion.spring.repository.EmpleadoRepository;
import com.evaluacion.spring.repository.SalarioRepository;
import com.evaluacion.spring.repository.SeguridadRepository;
import com.evaluacion.spring.service.EmpleadoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private SeguridadRepository seguridadRepository;

    @Autowired
    private SalarioRepository salarioRepository;

    public List<Empleado> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    public Empleado getEmpleadoById(String id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    public Empleado saveEmpleado(EmpleadoRequest request) {

        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(request.getIdEmpleado());
        empleado.setNombre(request.getNombre());
        empleado.setApellido1(request.getApellido1());
        empleado.setApellido2(request.getApellido2());
        empleado.setSexo(request.getSexo());
        empleado.setFNacimiento(request.getFNacimiento());
        empleado.setTelCelular(request.getTelCelular());
        empleado.setIdPuesto(request.getIdPuesto());
        System.out.println("guardar empleado nuevo");
        System.out.println(empleado);
        // Guardar el empleado
        empleadoRepository.save(empleado);

        Seguridad seguridad = new Seguridad();
        seguridad.setIdUsuario("ID"+request.getIdEmpleado());
        seguridad.setUsuario(request.getUsuario());
        seguridad.setPassword(request.getPassword());
        seguridad.setActivo(request.getActivo());
        seguridad.setIdEmpleado(request.getIdEmpleado());
        System.out.println("guardar datos deseguridad");
        System.out.println(seguridad);
        seguridadRepository.save(seguridad);
        return empleado;
    }

    public List<EmpleadoDTO> obtenerEmpleadosConActivo() {
        return empleadoRepository.findAllWithActivo();
    }

    @Transactional
    public void actualizarEmpleados(List<Empleado> empleados) {
        for (Empleado empleado : empleados) {
            Seguridad seguridad = seguridadRepository.findByIdEmpleado(empleado.getIdEmpleado())
                    .orElseThrow(() -> new RuntimeException("Registro de seguridad no encontrado para el empleado: " + empleado.getIdEmpleado()));
            seguridad.setActivo(empleado.getActivo());
            seguridadRepository.save(seguridad);
        }
    }

    @Transactional
    public void eliminarEmpleado(String idEmpleado) {
        /*Optional<Empleado> empleadoOptional = empleadoRepository.findById(idEmpleado);
        Empleado empleado = null;
        if(empleadoOptional.isPresent())
            empleado = empleadoOptional.get();*/
        System.out.println("eliminar empleado?");
        System.out.println(idEmpleado);
        seguridadRepository.deleteByIdEmpleado(idEmpleado);
        empleadoRepository.deleteById(idEmpleado);
    }

    public List<EmpleadoDTO> findEmpleadosBySexo(String sexo) {
        return empleadoRepository.findBySexo(sexo).stream()
                .map(empleado -> {
                    Optional<Seguridad> so;
                    Optional<Salario> sao;
                    Seguridad s = null;
                    Salario sa = null;
                    System.out.println("BUSCANDO SEGURIDAD Y PUESTO");
                    so = seguridadRepository.findByIdEmpleado(empleado.getIdEmpleado());
                    System.out.println(sa);
                    sao = salarioRepository.findByIdPuesto(empleado.getIdPuesto());
                    System.out.println(sao);
                    if(so.isPresent())
                    {
                        s = so.get();
                    }
                    if(sao.isPresent())
                        sa = sao.get();

                    EmpleadoDTO empleadoDTO = new EmpleadoDTO(empleado.getIdEmpleado(), empleado.getNombre(), empleado.getApellido1(), empleado.getApellido2(),
                            empleado.getSexo(), empleado.getFNacimiento(), empleado.getTelCelular(), sa.getSalario(), s.getActivo(), sa.getDescripcion(), s.getUsuario());

                    return empleadoDTO;
                })
                .collect(Collectors.toList());
    }
}