package com.evaluacion.spring.jwt;

import com.evaluacion.spring.service.impl.UsuarioServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFiltroPeticiones extends OncePerRequestFilter {


    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        /*try {
            String token = getToken(request);
            if (token != null && JwtProvider.validarTokenJWT(token)) {
                String nombreUsuario = JwtProvider.getNombreUsuario(token);
                if (nombreUsuario != null) {
                    UserDetails userDetail = usuarioService.loadUserByUsername(nombreUsuario);
                    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetail, null,
                            userDetail.getAuthorities());

                    auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(auth);
                }
            }
        } catch (Exception e) {

        }*/
        filterChain.doFilter(request, response);

    }

    private String getToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer")) {
            return header.replace("Bearer ", "");
        }

        return null;
    }

}