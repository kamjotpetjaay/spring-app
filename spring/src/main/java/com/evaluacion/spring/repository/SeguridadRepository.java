package com.evaluacion.spring.repository;

import com.evaluacion.spring.model.Seguridad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeguridadRepository extends JpaRepository<Seguridad, String> {

    @Query(value = "SELECT s.usuario FROM Seguridad s WHERE s.usuario = ?1")
    Optional<Seguridad> buscarPorNombreUsuario(String usuario);

    @Query(value = "SELECT s.* FROM seguridad s WHERE s.usuario = ?1 and s.password = ?2", nativeQuery = true)
    Optional<Seguridad> findByUserAndPassword(String usuario, String password);

    void deleteByIdEmpleado(String idEmpleado);
    Optional<Seguridad> findByIdEmpleado(String idEmpleado);
}