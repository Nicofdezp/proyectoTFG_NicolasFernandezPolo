package com.example.demo.controller.tarjetaBancaria;

import com.example.demo.controller.EndPointUris;
import com.example.demo.model.tarjeta_bancaria.TarjetaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(EndPointUris.API+EndPointUris.V1)
public interface TarjetaAPI {

    @PostMapping(EndPointUris.TARJETA)
    ResponseEntity<TarjetaDTO> create (@RequestBody final TarjetaDTO tarjetaDTO);

    @GetMapping(EndPointUris.TARJETA + EndPointUris.ID_VAR)
    ResponseEntity<TarjetaDTO> getCard_byId(@PathVariable final String id);
}
