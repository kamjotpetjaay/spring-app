package com.evaluacion.spring.controller;

import com.evaluacion.spring.dto.EmpleadoDTO;
import com.evaluacion.spring.dto.EmpleadoRequest;
import com.evaluacion.spring.model.Empleado;
import com.evaluacion.spring.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    /*@GetMapping
    public List<Empleado> getAllEmpleados() throws Exception {
        return empleadoService.getAllEmpleados();
    }*/

    @GetMapping
    public List<EmpleadoDTO> obtenerEmpleadosConActivo() {
        return empleadoService.obtenerEmpleadosConActivo();
    }

    @GetMapping("/{id}")
    public Empleado getEmpleadoById(@PathVariable String id) throws Exception {
        return empleadoService.getEmpleadoById(id);
    }

    @PostMapping
    public ResponseEntity<?> saveEmpleado(@RequestBody EmpleadoRequest request) {
        try {
            empleadoService.saveEmpleado(request);
            return ResponseEntity.ok("Empleado guardado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al actualizar empleados");
        }
    }

    // Endpoint para actualizar el estatus de los empleados
    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizarEmpleados(@RequestBody List<Empleado> empleados) {
        try {
            empleadoService.actualizarEmpleados(empleados);
            return ResponseEntity.ok("Empleados actualizados exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al actualizar empleados");
        }
    }

    // Endpoint para eliminar un empleado en las tablas Empleado y Seguridad
    @DeleteMapping("/eliminar/{idEmpleado}")
    public ResponseEntity<?> eliminarEmpleado(@PathVariable String idEmpleado) {
        System.out.println("Llega en eliminar?");
        try {
            empleadoService.eliminarEmpleado(idEmpleado);
            return ResponseEntity.ok("Empleado eliminado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al eliminar el empleado");
        }
    }

    //Endpoint para buscar por sexo y filtrar empleados
    @GetMapping("/buscar")
    public ResponseEntity<List<EmpleadoDTO>> getEmpleadosBySexo(@RequestParam(value = "sexo", required = false) String sexo) {
        List<EmpleadoDTO> empleados;
        if (sexo != null && !sexo.isEmpty()) {
            empleados = empleadoService.findEmpleadosBySexo(sexo);
        } else {
            empleados = empleadoService.obtenerEmpleadosConActivo();
        }
        return ResponseEntity.ok(empleados);
    }
}