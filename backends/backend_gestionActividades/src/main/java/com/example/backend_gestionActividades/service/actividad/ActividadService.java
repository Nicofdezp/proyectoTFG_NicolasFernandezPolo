package com.example.backend_gestionActividades.service.actividad;

import com.example.backend_gestionActividades.model.actividad.ActividadDTO;
import com.example.backend_gestionActividades.model.material.MaterialDTO;

import java.util.List;

public interface ActividadService {

    List<ActividadDTO> getAll();

    ActividadDTO getById(final String id);

    List<ActividadDTO> getByType(final String tipo_actividad);

    List<ActividadDTO> getByDificult(final String dificultad);

    boolean deleteAll();

    boolean delete(final String id);

    ActividadDTO create (final ActividadDTO actividadDTO, final String id_monitor);

    List<MaterialDTO> getMaterialAct_proporcionados(final String id);

    boolean deleteAll_proporcinados(final String id);

    boolean deleteById_proporcionados(final String id, final String id_mat);
}
