package com.example.backend_gestionActividades.controller.material;

import com.example.backend_gestionActividades.model.material.MaterialDTO;
import com.example.backend_gestionActividades.service.material.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class MaterialIMPL implements MaterialAPI {

    @Autowired
    private MaterialService materialService;

    @Override
    public ResponseEntity<List<MaterialDTO>> getAll() {
        return ResponseEntity.ok(materialService.getAll());
    }

    @Override
    public ResponseEntity<MaterialDTO> getById(String id) {
        return ResponseEntity.ok(materialService.getById(id));
    }

    @Override
    public ResponseEntity<Boolean> deleteAll() {
        return materialService.deleteAll()
                ? ResponseEntity.ok(true)
                : new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Boolean> deleteById(String id) {
        return materialService.deleteById(id)
                ? ResponseEntity.ok(true)
                : new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<MaterialDTO> create(MaterialDTO materialDTO) {
        return new ResponseEntity<>(materialService.create(materialDTO), HttpStatus.CREATED);
    }
}
