package com.evaluacion.spring.service.impl;

import com.evaluacion.spring.model.Seguridad;
import com.evaluacion.spring.repository.SeguridadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl /*implements UserDetailsService*/{
        @Autowired
        private SeguridadRepository seguridadRepository;

        /*@Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            Optional<Seguridad> seguridadOptional = seguridadRepository.buscarPorNombreUsuario(username);
            Seguridad usuario = null;
            if(seguridadOptional.isPresent())
                usuario = seguridadOptional.get();
            if (usuario == null)
                throw new UsernameNotFoundException("No existe el usuario");
            return usuario;
        }*/
}
