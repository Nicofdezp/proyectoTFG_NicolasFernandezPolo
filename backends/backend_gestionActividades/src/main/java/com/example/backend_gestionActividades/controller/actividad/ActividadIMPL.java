package com.example.backend_gestionActividades.controller.actividad;

import com.example.backend_gestionActividades.model.actividad.ActividadDTO;
import com.example.backend_gestionActividades.model.material.MaterialDTO;
import com.example.backend_gestionActividades.service.actividad.ActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class ActividadIMPL implements ActividadAPI {

    @Autowired
    private ActividadService actividadService;


    @Override
    public ResponseEntity<List<ActividadDTO>> getAll() {
        return ResponseEntity.ok(actividadService.getAll());
    }

    @Override
    public ResponseEntity<ActividadDTO> getByid(String id) {
        return ResponseEntity.ok(actividadService.getById(id));
    }

    @Override
    public ResponseEntity<List<ActividadDTO>> getByType(String tipo_actividad) {
        return ResponseEntity.ok(actividadService.getByType(tipo_actividad));
    }

    @Override
    public ResponseEntity<List<ActividadDTO>> getByDificult(String dificultad_actividad) {
        return ResponseEntity.ok(actividadService.getByDificult(dificultad_actividad));
    }

    @Override
    public ResponseEntity<Boolean> deleteAll() {
        return actividadService.deleteAll()
                ? ResponseEntity.ok(true)
                : new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Boolean> delete(String id) {
        return actividadService.delete(id)
                ? ResponseEntity.ok(true)
                : new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<ActividadDTO> create(ActividadDTO actividadDTO, String id_monitor) {
        return new ResponseEntity<>(actividadService.create(actividadDTO,id_monitor), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<MaterialDTO>> getMaterialAct_proporcionados(String id) {
        return ResponseEntity.ok(actividadService.getMaterialAct_proporcionados(id));
    }

    @Override
    public ResponseEntity<Boolean> deleteAll_proporcionados(String id) {
        return actividadService.deleteAll_proporcinados(id)
                ? ResponseEntity.ok(true)
                : new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Boolean> deleteById_proporcinado(String id, String id_mat) {
        return actividadService.deleteById_proporcionados(id, id_mat)
                ? ResponseEntity.ok(true)
                : new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<List<MaterialDTO>> getMaterialAct_necesarios(String id) {
        return ResponseEntity.ok(actividadService.getMaterialAct_necesarios(id));
    }

    @Override
    public ResponseEntity<Boolean> deleteAll_necesarios(String id) {
        return actividadService.deleteAll_necesarios(id)
                ? ResponseEntity.ok(true)
                : new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Boolean> deleteById_necesarios(String id, String id_mat) {
        return actividadService.deleteById_necesarios(id, id_mat)
                ? ResponseEntity.ok(true)
                : new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
