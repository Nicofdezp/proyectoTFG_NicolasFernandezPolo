package com.example.demo.controller.tarjetaBancaria;

import com.example.demo.model.tarjeta_bancaria.TarjetaDTO;
import com.example.demo.service.tarjeta_bancaria.TarjetaService;
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

    @Override
    public ResponseEntity<TarjetaDTO> create(TarjetaDTO tarjetaDTO) {
        return new ResponseEntity<>(tarjetaService.create(tarjetaDTO), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<TarjetaDTO> getCard_byId(String id) {
        return ResponseEntity.ok(tarjetaService.getCard_byId(id));
    }
}
