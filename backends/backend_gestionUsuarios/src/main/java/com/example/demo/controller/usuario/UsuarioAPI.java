package com.example.demo.controller.usuario;

import com.example.demo.controller.EndPointUris;
import com.example.demo.model.loginResponse.LoginResponse;
import com.example.demo.model.loginResponse.LoginType;
import com.example.demo.model.usuario.UsuarioDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping()
@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface UsuarioAPI {

    @PostMapping(EndPointUris.AUTH_LOGIN)
    ResponseEntity<LoginResponse> login(@RequestBody LoginType loginType);

    @PutMapping(EndPointUris.DATOS + EndPointUris.ID_VAR)
    ResponseEntity<UsuarioDTO> cambiardatos(@PathVariable("id") final String id, @RequestBody final Map<String, String> datos);

    @PutMapping(EndPointUris.CONTRA + EndPointUris.ID_VAR)
    ResponseEntity<UsuarioDTO> cambiarContra(@PathVariable("id") final String id, @RequestBody final Map<String, String> password);

    @GetMapping(EndPointUris.USUARIOS)
    ResponseEntity<List<UsuarioDTO>> getAll();

    @GetMapping(EndPointUris.ID + EndPointUris.ID_VAR)
    ResponseEntity<UsuarioDTO> getUserByid(@PathVariable final String id);

    @GetMapping(EndPointUris.USUARIO + EndPointUris.NOMBREUSUARIO)
    ResponseEntity<UsuarioDTO> getUserByname(@PathVariable final String nombre_usuario);

    @DeleteMapping(EndPointUris.BORRAR_USUARIO + EndPointUris.ID_VAR)
    ResponseEntity<Boolean> delete(@PathVariable final String id);

    @DeleteMapping(EndPointUris.USUARIOS)
    ResponseEntity<Boolean> deleteAll();

    @PostMapping(EndPointUris.REGISTRO)
    ResponseEntity<UsuarioDTO> create( @RequestBody final UsuarioDTO usuarioDTO );

    @PutMapping(EndPointUris.ID_VAR + EndPointUris.ID_VAR2)
    ResponseEntity<UsuarioDTO> introducir_Tarjeta(@PathVariable("id") final String id_usuario, @PathVariable("id2") final String num_tarjeta);

}
