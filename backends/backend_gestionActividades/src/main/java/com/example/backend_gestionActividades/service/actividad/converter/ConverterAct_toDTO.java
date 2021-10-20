package com.example.backend_gestionActividades.service.actividad.converter;

import com.example.backend_gestionActividades.model.actividad.ActividadDTO;
import com.example.backend_gestionActividades.model.actividad.ActividadVO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ConverterAct_toDTO implements Converter<ActividadVO, ActividadDTO> {
    @Override
    public ActividadDTO convert(ActividadVO actividad) {
        return ActividadDTO.builder()
                .id(actividad.getId())
                .nombre_actividad(actividad.getNombre_actividad())
                .tipo_actividad(actividad.getTipo_actividad())
                .descripcion(actividad.getDescripcion())
                .dificultad(actividad.getDificultad())
                .materiales_proporcionados(actividad.getMateriales_proporcionados())
                .materiales_necesarios(actividad.getMateriales_necesarios())
                .fecha_inicio(actividad.getFecha_inicio())
                .fecha_final(actividad.getFecha_final())
                .precio(actividad.getPrecio())
                .build();
    }
}
