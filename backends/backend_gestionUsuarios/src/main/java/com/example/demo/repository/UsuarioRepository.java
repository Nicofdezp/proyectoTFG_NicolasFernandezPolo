package com.example.demo.repository;

import com.example.demo.model.usuario.UsuarioVO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<UsuarioVO, String> {
}
