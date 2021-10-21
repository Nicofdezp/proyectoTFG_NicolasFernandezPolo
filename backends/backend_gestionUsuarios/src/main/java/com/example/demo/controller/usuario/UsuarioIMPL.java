package com.example.demo.controller.usuario;

import com.example.demo.model.usuario.UsuarioDTO;
import com.example.demo.service.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class UsuarioIMPL implements UsuarioAPI{

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public ResponseEntity<List<UsuarioDTO>> getAll() {
        return ResponseEntity.ok(usuarioService.getAll());
    }

    @Override
    public ResponseEntity<UsuarioDTO> getUserByid(String id) {
        return ResponseEntity.ok(usuarioService.getById(id));
    }

    @Override
    public ResponseEntity<UsuarioDTO> getUserByname(String nombre_usuario) {
        return ResponseEntity.ok(usuarioService.getByUserName(nombre_usuario));
    }

    @Override
    public ResponseEntity<Boolean> delete(String id) {
        return usuarioService.delete(id)
                ? ResponseEntity.ok(true)
                : new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Boolean> deleteAll() {
        return usuarioService.deleteAll()
                ? ResponseEntity.ok(true)
                : new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<UsuarioDTO> create(UsuarioDTO usuarioDTO) {
        return new ResponseEntity<>(usuarioService.create(usuarioDTO), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<UsuarioDTO> introducir_Tarjeta(String id_usuario, String num_tarjeta) {
        return ResponseEntity.ok(usuarioService.introducir_Tarjeta(id_usuario,num_tarjeta));
    }
}
