package com.example.backend_gestionActividades.controller.actividad;


import com.example.backend_gestionActividades.controller.EndPointUris;
import com.example.backend_gestionActividades.model.actividad.ActividadDTO;
import com.example.backend_gestionActividades.model.material.MaterialDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping()
public interface ActividadAPI {

    @GetMapping()
    ResponseEntity<List<ActividadDTO>> getAll();

    @GetMapping(EndPointUris.ID)
    ResponseEntity<ActividadDTO> getByid(@PathVariable final String id);

    @GetMapping(EndPointUris.TIPO_ACTIVIDAD + EndPointUris.TIPO_ACTIVIDAD_VAR)
    ResponseEntity<List<ActividadDTO>> getByType(@PathVariable final String tipo_actividad);

    @GetMapping(EndPointUris.DIFICULTAD_ACTIVIDAD + EndPointUris.DIFICULTAD_ACTIVIDAD_VAR)
    ResponseEntity<List<ActividadDTO>> getByDificult(@PathVariable final String dificultad_actividad);

    @DeleteMapping()
    ResponseEntity<Boolean> deleteAll();

    @DeleteMapping(EndPointUris.BORRAR + EndPointUris.ID)
    ResponseEntity<Boolean> delete(@PathVariable final String id);

    @PostMapping(EndPointUris.CREAR_ACTIVIDAD + EndPointUris.ID)
    ResponseEntity<ActividadDTO> create(@RequestBody final ActividadDTO actividadDTO, @PathVariable("id") final String id_monitor);

    @GetMapping(EndPointUris.ID + EndPointUris.MATERIAL)
    ResponseEntity<List<MaterialDTO>> getMaterialAct_proporcionados(@PathVariable final String id);

    @PutMapping(EndPointUris.ID + EndPointUris.MATERIAL)
    ResponseEntity<Boolean> deleteAll_proporcionados(@PathVariable final String id);

    @PutMapping(EndPointUris.ID + EndPointUris.MATERIAL + EndPointUris.ID2)
    ResponseEntity<Boolean> deleteById_proporcinado(@PathVariable("id") final String id, @PathVariable("id2") final String id_mat);

}
