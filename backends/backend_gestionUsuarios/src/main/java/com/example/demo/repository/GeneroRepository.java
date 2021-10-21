package com.example.demo.repository;

import com.example.demo.model.genero.GeneroVO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends MongoRepository<GeneroVO, String> {
}
