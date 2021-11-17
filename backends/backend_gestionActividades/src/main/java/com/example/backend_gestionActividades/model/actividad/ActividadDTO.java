package com.example.backend_gestionActividades.model.actividad;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ActividadDTO {
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
    private int capacidad_minima;
    private int capacidad_maxima;
    private int capacidad_monitor;
}


/*
{
    "nombre_actividad" : "",
    "tipo_actividad":"",
    "descripcion" : "",
    "dificultad" : "",
    "materiales_proporcionados" : [],
    "materiales_necesarios" : [],
    "fecha_inicio" : "1471212000",
    "fecha_final" : "1471212000",
    "precio" : "2.5"
}
*/

