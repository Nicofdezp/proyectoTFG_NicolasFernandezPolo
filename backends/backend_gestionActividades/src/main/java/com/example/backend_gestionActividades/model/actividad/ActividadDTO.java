package com.example.backend_gestionActividades.model.actividad;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ActividadDTO {
    private String id;
    private String nombre_actividad;
    private String tipo_actividad;
    private String descripcion;
    private String dificultad;
    private ArrayList<String> materiales_proporcionados;
    private ArrayList<String> materiales_necesarios;
    private ArrayList<String> personas_finales;
    private ArrayList<String> personas_reserva;
    private ArrayList<String> personas_monitor;
    private Date fecha_inicio;
    private Date fecha_final;
}
