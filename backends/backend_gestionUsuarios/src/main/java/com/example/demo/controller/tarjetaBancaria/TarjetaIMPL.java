package com.example.demo.controller.tarjetaBancaria;

import com.example.demo.model.tarjeta_bancaria.TarjetaDTO;
import com.example.demo.model.usuario.UsuarioDTO;
import com.example.demo.service.tarjeta_bancaria.TarjetaService;
import com.example.demo.service.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TarjetaIMPL implements TarjetaAPI{

    @Autowired
    private TarjetaService tarjetaService;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public ResponseEntity<TarjetaDTO> create(TarjetaDTO tarjetaDTO) {
        return new ResponseEntity<>(tarjetaService.create(tarjetaDTO), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<TarjetaDTO> getCard_byId(String id) {
        return ResponseEntity.ok(tarjetaService.getCard_byId(id));
    }

    @Override
    public ResponseEntity<Boolean> removeUserCard(String id) {
        return tarjetaService.removeUserCard(id)
                ? ResponseEntity.ok(true)
                : new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<UsuarioDTO> getUser_Card(String id) {
        return ResponseEntity.ok(usuarioService.getById(tarjetaService.getCard_byId(id).getId_usuario()));
    }

    @Override
    public ResponseEntity<TarjetaDTO> restarSaldo(String id, String saldo) {
        return ResponseEntity.ok(tarjetaService.restarSaldo(id, saldo));
    }

    @Override
    public ResponseEntity<TarjetaDTO> sumarSaldo(String id, String saldo) {
        return ResponseEntity.ok(tarjetaService.sumarSaldo(id, saldo));
    }
}
