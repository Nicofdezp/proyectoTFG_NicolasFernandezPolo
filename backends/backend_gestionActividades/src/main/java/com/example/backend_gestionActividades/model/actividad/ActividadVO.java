package com.example.backend_gestionActividades.model.actividad;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "Actividad")
public class ActividadVO {

    private String id;
    private String nombre_actividad;
    private String tipo_actividad;
    private String descripcion;
    private String dificultad;
    private ArrayList<String> materiales_proporcionados;
    private ArrayList<String> materiales_necesarios;
    private Date fecha_inicio;
    private Date fecha_final;
    private Double precio;
}
