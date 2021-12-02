package com.example.backend_gestionReservas.model;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TipoReserva {

    private String id_actividad;
    private String nombre_actividad;
    private String estado_reserva;

}
