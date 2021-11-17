package com.example.demo.service.usuario;

import com.example.demo.model.usuario.UsuarioDTO;
import java.util.List;

public interface UsuarioService {

    List<UsuarioDTO> getAll();

    UsuarioDTO getById(final String id);

    UsuarioDTO getByUserName(final String nombre_usuario);

    boolean delete(final String id);

    boolean deleteAll();

    UsuarioDTO create(final UsuarioDTO usuarioDTO);

    String getGenero_user(final String id);

    String getTarjeta_user(final String id);

    UsuarioDTO introducir_Tarjeta(final String id_usuario, final String numero_tajeta);
}
