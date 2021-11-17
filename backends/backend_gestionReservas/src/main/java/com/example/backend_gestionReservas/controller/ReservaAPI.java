package com.example.backend_gestionReservas.controller;

import com.example.backend_gestionReservas.model.ReservaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping()
public interface ReservaAPI {

    @GetMapping()
    ResponseEntity<List<ReservaDTO>> getAll();

    @PutMapping("realizarReserva/{id_actividad}/{id_usuario}")
    ResponseEntity<ReservaDTO> realizarReserva(@PathVariable final String id_actividad, @PathVariable final String id_usuario);

    @PutMapping("realizarPago/{id_actividad}/{id_usuario}")
    ResponseEntity<ReservaDTO> relizarPago(@PathVariable final String id_actividad, @PathVariable final String id_usuario);

    @PostMapping("crearReserva/{id_actividad}/{id_monitor}")
    ResponseEntity<ReservaDTO> create(@PathVariable final String id_actividad, @PathVariable final String id_monitor);
}
