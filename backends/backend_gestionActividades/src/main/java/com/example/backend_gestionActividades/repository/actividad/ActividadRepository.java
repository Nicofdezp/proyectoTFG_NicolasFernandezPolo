package com.example.backend_gestionActividades.repository.actividad;

import com.example.backend_gestionActividades.model.actividad.ActividadVO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActividadRepository extends MongoRepository<ActividadVO, String> {
}
