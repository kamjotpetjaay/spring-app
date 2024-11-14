package com.evaluacion.spring.service.impl;

import com.evaluacion.spring.dto.LoginDTO;
import com.evaluacion.spring.jwt.JwtProvider;
import com.evaluacion.spring.model.Seguridad;
import com.evaluacion.spring.repository.SeguridadRepository;
import com.evaluacion.spring.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private SeguridadRepository seguridadRepository;

    @Override
    public String login(LoginDTO loginDTO) throws Exception {
        //Comentamos esto porque se está utilizando texto plano en user y password, ya que se meten de manera manual a la db los datos.
        //No dio tiempo implementar esta parte mas desarrollado, así que solo se genera unt oken generico.
        //Authentication auth = authenticationManager.authenticate(
        //        new UsernamePasswordAuthenticationToken(loginDTO.getUsuario(), loginDTO.getPassword()));
        //SecurityContextHolder.getContext().setAuthentication(auth);

        Optional<Seguridad> usuarioOptional = seguridadRepository.buscarPorNombreUsuario(loginDTO.getUsuario());
        boolean usuarioPresente = usuarioOptional.isPresent();
        if(!usuarioPresente)
            throw new Exception("Usuario no encontrado");
        Optional<Seguridad> passwordOptional = seguridadRepository.findByUserAndPassword(loginDTO.getUsuario(), loginDTO.getPassword());
        boolean userPassPresent = passwordOptional.isPresent();
        if(!userPassPresent)
            throw new Exception("Password invalido");
        if(passwordOptional.get().getActivo() == 'N')
            throw new Exception("Usuario inactivo");
        System.out.println("generando token generico");
        return JwtProvider.generarTokenJWT(loginDTO.getUsuario());
    }
}
