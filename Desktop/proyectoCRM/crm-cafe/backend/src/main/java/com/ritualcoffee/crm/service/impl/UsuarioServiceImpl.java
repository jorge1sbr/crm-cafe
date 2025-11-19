package com.ritualcoffee.crm.service.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ritualcoffee.crm.dto.LoginRequest;
import com.ritualcoffee.crm.dto.RegistroRequest;
import com.ritualcoffee.crm.dto.UsuarioResponse;
import com.ritualcoffee.crm.entity.Usuario;
import com.ritualcoffee.crm.repository.UsuarioRepository;
import com.ritualcoffee.crm.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    @Transactional
    public UsuarioResponse registrarUsuario(RegistroRequest request) {

        if (usuarioRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("El email ya está registrado");
        }

        Usuario usuario = new Usuario();
        usuario.setNombre(request.getNombre());
        usuario.setApellidos(request.getApellidos());
        usuario.setEmail(request.getEmail());
        // ⚠️ Para el proyecto: guardamos la contraseña tal cual
        usuario.setPasswordHash(request.getPassword());
        usuario.setDireccion(request.getDireccion());
        usuario.setCodigoPostal(request.getCodigoPostal());
        usuario.setRol("CLIENTE");
        usuario.setFechaAlta(LocalDateTime.now());

        Usuario guardado = usuarioRepository.save(usuario);

        UsuarioResponse response = new UsuarioResponse();
        response.setId(guardado.getIdUsuario());
        response.setNombre(guardado.getNombre());
        response.setApellidos(guardado.getApellidos());
        response.setEmail(guardado.getEmail());
        response.setRol(guardado.getRol());
        response.setMensaje("Usuario registrado correctamente");

        return response;
    }

    @Override
    public UsuarioResponse login(LoginRequest request) {

        Usuario usuario = usuarioRepository.findByEmail(request.getEmail())
            .orElseThrow(() -> new RuntimeException("Credenciales incorrectas"));

        // Comparación simple de contraseña (texto plano)
        if (!usuario.getPasswordHash().equals(request.getPassword())) {
            throw new RuntimeException("Credenciales incorrectas");
        }

        UsuarioResponse response = new UsuarioResponse();
        response.setId(usuario.getIdUsuario());
        response.setNombre(usuario.getNombre());
        response.setApellidos(usuario.getApellidos());
        response.setEmail(usuario.getEmail());
        response.setRol(usuario.getRol());
        response.setMensaje("Login correcto");

        return response;
    }
}
