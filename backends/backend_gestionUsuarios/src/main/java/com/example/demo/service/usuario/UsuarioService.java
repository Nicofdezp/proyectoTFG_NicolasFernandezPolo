package com.example.demo.service.usuario;

import com.example.demo.model.loginResponse.LoginResponse;
import com.example.demo.model.usuario.UsuarioDTO;
import java.util.List;
import java.util.Map;

public interface UsuarioService {

    LoginResponse loginUsuario(final String user_name, final String password);

    UsuarioDTO cambiarContra(final String id, final Map<String, String> password);

    UsuarioDTO cambiarDatos(final String id, final Map<String, String> datos);

    List<UsuarioDTO> getAll();

    UsuarioDTO getById(final String id);

    UsuarioDTO getByUserName(final String nombre_usuario);

    boolean delete(final String id);

    boolean deleteAll();

    UsuarioDTO create(final UsuarioDTO usuarioDTO);


    String getTarjeta_user(final String id);

    UsuarioDTO introducir_Tarjeta(final String id_usuario, final String numero_tajeta);
}
