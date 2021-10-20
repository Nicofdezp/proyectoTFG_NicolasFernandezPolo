package com.example.backend_gestionActividades.repository.material;

import com.example.backend_gestionActividades.model.material.MaterialVO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MaterialRepository extends MongoRepository<MaterialVO, String> {
}
