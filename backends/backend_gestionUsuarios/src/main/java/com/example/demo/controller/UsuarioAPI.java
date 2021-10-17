package com.example.demo.controller;

import com.example.demo.model.UsuarioDTO;
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

}
