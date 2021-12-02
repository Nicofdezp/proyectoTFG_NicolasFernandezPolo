package com.example.backend_gestionReservas.controller;

import com.example.backend_gestionReservas.model.ReservaDTO;
import com.example.backend_gestionReservas.model.TipoReserva;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping()
public interface ReservaAPI {

    @DeleteMapping("/reservas")
    ResponseEntity<Boolean> deleteAll();

    @GetMapping("/reservas")
    ResponseEntity<List<ReservaDTO>> getAll();

    @PutMapping("realizarReserva/{id_actividad}/{id_usuario}")
    ResponseEntity<ReservaDTO> realizarReserva(@PathVariable final String id_actividad, @PathVariable final String id_usuario);

    @PutMapping("realizarPago/{id_actividad}/{id_usuario}")
    ResponseEntity<ReservaDTO> relizarPago(@PathVariable final String id_actividad, @PathVariable final String id_usuario);

    @PostMapping("crearReserva/{id_actividad}/{id_monitor}")
    ResponseEntity<ReservaDTO> create(@PathVariable final String id_actividad, @PathVariable final String id_monitor);

    @GetMapping("conseguirReservas/{id_usuario}")
    ResponseEntity<List<TipoReserva>> getReservasUser(@PathVariable("id_usuario") final String id_usuario);

    @GetMapping("conseguirReserva/{id_act}")
    ResponseEntity<ReservaDTO> getReservaByAct(@PathVariable("id_act") final String id_act);

    @GetMapping("conseguirActividad/{id_reserva}")
    ResponseEntity<String> getActbyReserva(@PathVariable("id_reserva") final String id_reserva);
}
