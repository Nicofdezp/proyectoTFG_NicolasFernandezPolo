package com.example.backend_gestionReservas.model;

import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RerservaDTO {
    private String id;
    private String id_usuario;
    private String id_actividad;

}
