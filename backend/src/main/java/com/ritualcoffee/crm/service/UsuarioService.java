package com.ritualcoffee.crm.service;

import com.ritualcoffee.crm.dto.LoginRequest;
import com.ritualcoffee.crm.dto.RegistroRequest;
import com.ritualcoffee.crm.dto.UsuarioResponse;

public interface UsuarioService {

    UsuarioResponse registrarUsuario(RegistroRequest request);

    UsuarioResponse login(LoginRequest request);
}
