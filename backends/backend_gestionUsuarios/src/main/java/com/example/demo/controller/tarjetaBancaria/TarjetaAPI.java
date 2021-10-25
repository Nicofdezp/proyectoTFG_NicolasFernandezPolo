package com.example.demo.controller.tarjetaBancaria;

import com.example.demo.controller.EndPointUris;
import com.example.demo.model.tarjeta_bancaria.TarjetaDTO;
import com.example.demo.model.usuario.UsuarioDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(EndPointUris.API+EndPointUris.V1+EndPointUris.TARJETA)
public interface TarjetaAPI {

    @PostMapping()
    ResponseEntity<TarjetaDTO> create (@RequestBody final TarjetaDTO tarjetaDTO);

    @GetMapping(EndPointUris.ID_VAR)
    ResponseEntity<TarjetaDTO> getCard_byId(@PathVariable final String id);

    @DeleteMapping( EndPointUris.ID_VAR)
    ResponseEntity<Boolean> removeUserCard(@PathVariable final String id);

    @GetMapping(EndPointUris.ID_VAR + EndPointUris.USUARIOS)
    ResponseEntity<UsuarioDTO> getUser_Card(@PathVariable final String id);

    @PutMapping(EndPointUris.ID_VAR+EndPointUris.RESTAR+EndPointUris.SALDO)
    ResponseEntity<TarjetaDTO> restarSaldo(@PathVariable("id") final String id, @PathVariable("saldo") final String saldo);

    @PutMapping(EndPointUris.ID_VAR+EndPointUris.SUMAR+EndPointUris.SALDO)
    ResponseEntity<TarjetaDTO> sumarSaldo(@PathVariable("id") final String id, @PathVariable("saldo") final String saldo);

}
