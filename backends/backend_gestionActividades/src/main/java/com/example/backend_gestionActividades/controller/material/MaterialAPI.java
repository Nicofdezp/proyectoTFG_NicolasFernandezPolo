package com.example.backend_gestionActividades.controller.material;

import com.example.backend_gestionActividades.controller.EndPointUris;
import com.example.backend_gestionActividades.model.material.MaterialDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(EndPointUris.API+EndPointUris.V1+EndPointUris.MATERIAL)
public interface MaterialAPI {

    @GetMapping()
    ResponseEntity<List<MaterialDTO>> getAll();

    @GetMapping(EndPointUris.ID)
    ResponseEntity<MaterialDTO> getById(@PathVariable final String id);

    @DeleteMapping()
    ResponseEntity<Boolean> deleteAll();

    @DeleteMapping(EndPointUris.ID)
    ResponseEntity<Boolean> deleteById(final String id);

    @PostMapping(EndPointUris.CREAR_MATERIAL)
    ResponseEntity<MaterialDTO> create(@RequestBody final MaterialDTO materialDTO);
}
