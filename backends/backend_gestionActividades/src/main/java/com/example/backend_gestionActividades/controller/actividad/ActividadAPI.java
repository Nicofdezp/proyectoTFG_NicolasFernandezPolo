package com.example.backend_gestionActividades.controller.actividad;


import com.example.backend_gestionActividades.controller.EndPointUris;
import com.example.backend_gestionActividades.model.actividad.ActividadDTO;
import com.example.backend_gestionActividades.model.material.MaterialDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping()
@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface ActividadAPI {

    @GetMapping(EndPointUris.ACTIVIDADES)
    ResponseEntity<List<ActividadDTO>> getAll();

    @GetMapping(EndPointUris.ID)
    ResponseEntity<ActividadDTO> getByid(@PathVariable final String id);

    @GetMapping(EndPointUris.TIPO_ACTIVIDAD + EndPointUris.TIPO_ACTIVIDAD_VAR)
    ResponseEntity<List<ActividadDTO>> getByType(@PathVariable final String tipo_actividad);

    @GetMapping(EndPointUris.DIFICULTAD_ACTIVIDAD + EndPointUris.DIFICULTAD_ACTIVIDAD_VAR)
    ResponseEntity<List<ActividadDTO>> getByDificult(@PathVariable final String dificultad_actividad);

    @DeleteMapping(EndPointUris.ACTIVIDADES)
    ResponseEntity<Boolean> deleteAll();

    @DeleteMapping(EndPointUris.BORRAR + EndPointUris.ID)
    ResponseEntity<Boolean> delete(@PathVariable final String id);

    @PostMapping(EndPointUris.CREAR_ACTIVIDAD + EndPointUris.ID)
    ResponseEntity<ActividadDTO> create(@RequestBody final ActividadDTO actividadDTO, @PathVariable("id") final String id_monitor);

    @GetMapping(EndPointUris.ID + EndPointUris.MATERIALPROPORCIONADO)
    ResponseEntity<List<MaterialDTO>> getMaterialAct_proporcionados(@PathVariable final String id);

    @PutMapping(EndPointUris.ID + EndPointUris.MATERIALPROPORCIONADO)
    ResponseEntity<Boolean> deleteAll_proporcionados(@PathVariable final String id);

    @PutMapping(EndPointUris.ID + EndPointUris.MATERIALPROPORCIONADO + EndPointUris.ID2)
    ResponseEntity<Boolean> deleteById_proporcinado(@PathVariable("id") final String id, @PathVariable("id2") final String id_mat);

    @GetMapping(EndPointUris.ID + EndPointUris.MATERIALNECESARIO)
    ResponseEntity<List<MaterialDTO>> getMaterialAct_necesarios(@PathVariable final String id);

    @PutMapping(EndPointUris.ID + EndPointUris.MATERIALNECESARIO)
    ResponseEntity<Boolean> deleteAll_necesarios(@PathVariable final String id);

    @PutMapping(EndPointUris.ID + EndPointUris.MATERIALNECESARIO + EndPointUris.ID2)
    ResponseEntity<Boolean> deleteById_necesarios(@PathVariable("id") final String id, @PathVariable("id2") final String id_mat);

}
