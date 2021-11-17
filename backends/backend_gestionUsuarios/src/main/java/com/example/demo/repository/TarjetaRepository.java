package com.example.demo.repository;

import com.example.demo.model.tarjeta_bancaria.TarjetaVO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarjetaRepository extends MongoRepository<TarjetaVO, String> {
}
