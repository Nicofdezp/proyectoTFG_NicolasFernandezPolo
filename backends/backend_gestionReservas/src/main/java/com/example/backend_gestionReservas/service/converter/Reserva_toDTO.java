package com.example.backend_gestionReservas.service.converter;

import com.example.backend_gestionReservas.model.ReservaDTO;
import com.example.backend_gestionReservas.model.ReservaVO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class Reserva_toDTO implements Converter<ReservaVO, ReservaDTO> {
    @Override
    public ReservaDTO convert(ReservaVO reserva) {
        return ReservaDTO.builder()
                .id(reserva.getId())
                .personas_finales(reserva.getPersonas_finales())
                .personas_reserva(reserva.getPersonas_reserva())
                .personas_monitor(reserva.getPersonas_monitor())
                .id_actividad(reserva.getId_actividad())
                .build();
    }
}
