package com.example.backend_gestionReservas.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "Reserva")
public class ReservaVO {

    private String id;
    private String id_usuario;
    private String id_actividad;
}
