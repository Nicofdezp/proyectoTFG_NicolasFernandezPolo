package com.example.backend_gestionReservas.service;

import com.example.backend_gestionReservas.model.ReservaDTO;
import com.example.backend_gestionReservas.model.TipoReserva;


import java.util.List;
import java.util.Map;

public interface ReservaService {

    List<ReservaDTO> getAll();

    ReservaDTO getById(final String id);

    boolean deleteAll();

    boolean deleteById(final String id);

    ReservaDTO create(final String id_actividad, final String id_monitor);

    ReservaDTO eliminarPersona(final String id_actividad, final String id_usuario);

    String getNombreActividabyId(final String id_reserva);

    ReservaDTO realizarPago(final String id_actividad, final String id_usuario);

    ReservaDTO introducir_monitor(final String id_actividad, final String id_monitor);

    Boolean pagoCheck(final String id_reserva, final String id_usuario);

    ReservaDTO getRerserva_byActivity(final String id_actividad);

    List<TipoReserva> getReservas_usuario(final String id_usuario);

    ReservaDTO realizarReserva(final String id_actividad, final String id_usuario);
}
