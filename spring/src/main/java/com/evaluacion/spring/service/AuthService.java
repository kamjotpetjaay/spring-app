package com.evaluacion.spring.service;

import com.evaluacion.spring.dto.LoginDTO;

public interface AuthService {
    public String login(LoginDTO loginDTO) throws Exception;
}
