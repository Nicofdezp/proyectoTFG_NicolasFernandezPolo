package com.example.backend_gestionReservas.model;

import lombok.*;

import java.util.ArrayList;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RerservaDTO {
    private String id;
    private ArrayList<String> personas_finales;
    private ArrayList<String> personas_reserva;
    private ArrayList<String> personas_monitor;
    private String id_actividad;

}
