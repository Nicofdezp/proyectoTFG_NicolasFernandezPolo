package com.example.backend_gestionReservas.service.converter;

import com.example.backend_gestionReservas.model.ReservaDTO;
import com.example.backend_gestionReservas.model.ReservaVO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class Reserva_toVO implements Converter<ReservaDTO, ReservaVO> {
    @Override
    public ReservaVO convert(ReservaDTO reserva) {
        return ReservaVO.builder()
                .id(reserva.getId())
                .personas_finales(reserva.getPersonas_finales())
                .personas_reserva(reserva.getPersonas_reserva())
                .personas_monitor(reserva.getPersonas_monitor())
                .id_actividad(reserva.getId_actividad())
                .build();
    }
}
