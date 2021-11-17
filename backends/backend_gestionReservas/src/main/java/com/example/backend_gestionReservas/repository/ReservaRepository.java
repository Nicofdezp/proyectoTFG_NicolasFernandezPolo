package com.example.backend_gestionReservas.repository;

import com.example.backend_gestionReservas.model.ReservaVO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends MongoRepository<ReservaVO, String> {
}
