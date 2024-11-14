package com.evaluacion.spring.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE)
public class Seguridad/* implements UserDetails */{

    @Id
    @Column(name = "id_usuario")
    private String idUsuario;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "password")
    private String password;

    @Column(name = "activo")
    private char activo;

    @Column(name = "id_empleado")
    private String idEmpleado;

    /*@OneToOne
    @JoinColumn(name = "idEmpleado", referencedColumnName = "idEmpleado", insertable = false, updatable = false)
    private Empleado empleado;*/

    /*@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return usuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return activo == 'S';
    }*/
}
