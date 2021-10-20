package com.example.backend_gestionActividades.service.material;

import com.example.backend_gestionActividades.model.material.MaterialDTO;

import java.util.List;

public interface MaterialService {

    List<MaterialDTO> getAll();

    MaterialDTO getById(final String id);

    Boolean deleteAll();

    Boolean deleteById(final String id);

    MaterialDTO create(final MaterialDTO material);
}
