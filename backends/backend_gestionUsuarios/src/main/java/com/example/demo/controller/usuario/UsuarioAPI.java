package com.example.demo.controller.usuario;

import com.example.demo.controller.EndPointUris;
import com.example.demo.model.usuario.UsuarioDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(EndPointUris.API+EndPointUris.V1)
public interface UsuarioAPI {

    @GetMapping(EndPointUris.USUARIOS)
    ResponseEntity<List<UsuarioDTO>> getAll();

    @GetMapping(EndPointUris.USUARIOS +EndPointUris.ID+ EndPointUris.ID_VAR)
    ResponseEntity<UsuarioDTO> getUserByid(@PathVariable final String id);

    @GetMapping(EndPointUris.USUARIOS + EndPointUris.NOMBREUSUARIO)
    ResponseEntity<UsuarioDTO> getUserByname(@PathVariable final String nombre_usuario);

    @DeleteMapping(EndPointUris.USUARIOS +EndPointUris.ID+ EndPointUris.ID_VAR)
    ResponseEntity<Boolean> delete(@PathVariable final String id);

    @DeleteMapping(EndPointUris.USUARIOS)
    ResponseEntity<Boolean> deleteAll();

    @PostMapping(EndPointUris.REGISTRO)
    ResponseEntity<UsuarioDTO> create( @RequestBody final UsuarioDTO usuarioDTO );

    @PutMapping(EndPointUris.USUARIOS + EndPointUris.ID_VAR + EndPointUris.ID_VAR2)
    ResponseEntity<UsuarioDTO> introducir_Tarjeta(@PathVariable("id") final String id_usuario, @PathVariable("id2") final String num_tarjeta);

    @GetMapping(EndPointUris.USUARIOS + EndPointUris.ID_VAR + EndPointUris.GENERO)
    ResponseEntity<String> getGenero_user(@PathVariable final String id);

}
