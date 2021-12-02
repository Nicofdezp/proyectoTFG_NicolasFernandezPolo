package com.example.backend_gestionReservas.controller;

import com.example.backend_gestionReservas.model.ReservaDTO;
import com.example.backend_gestionReservas.model.TipoReserva;
import com.example.backend_gestionReservas.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin
public class ReservaIMPL implements ReservaAPI{

    @Autowired
    ReservaService reservaService;

    @Override
    public ResponseEntity<Boolean> deleteAll() {
        return reservaService.deleteAll()
                ? ResponseEntity.ok(true)
                : new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<List<ReservaDTO>> getAll() {
        return ResponseEntity.ok(reservaService.getAll());
    }

    @Override
    public ResponseEntity<ReservaDTO> realizarReserva(String id_actividad, String id_usuario) {
        return ResponseEntity.ok(reservaService.realizarReserva(id_actividad, id_usuario));
    }

    @Override
    public ResponseEntity<ReservaDTO> relizarPago(String id_actividad, String id_usuario) {
        return ResponseEntity.ok(reservaService.realizarPago(id_actividad, id_usuario));
    }

    @Override
    public ResponseEntity<ReservaDTO> create(String id_actividad, String id_monitor) {
        return new ResponseEntity<>(reservaService.create(id_actividad,id_monitor), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<TipoReserva>> getReservasUser(String id_usuario) {
        return ResponseEntity.ok(reservaService.getReservas_usuario(id_usuario));
    }

    @Override
    public ResponseEntity<ReservaDTO> getReservaByAct(String id_act) {
        return ResponseEntity.ok(reservaService.getRerserva_byActivity(id_act));
    }

    @Override
    public ResponseEntity<String> getActbyReserva(String id_reserva) {
        return ResponseEntity.ok(reservaService.getNombreActividabyId(id_reserva));
    }


}
