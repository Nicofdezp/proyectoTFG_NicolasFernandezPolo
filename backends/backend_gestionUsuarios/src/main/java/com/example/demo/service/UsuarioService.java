package com.example.demo.service;

import com.example.demo.model.UsuarioDTO;
import java.util.List;

public interface UsuarioService {

    List<UsuarioDTO> getAll();

    UsuarioDTO getById(final String id);

    UsuarioDTO getByUserName(final String nombre_usuario);

    boolean delete(final String id);

    boolean deleteAll();

    UsuarioDTO create(final UsuarioDTO usuarioDTO);
}
