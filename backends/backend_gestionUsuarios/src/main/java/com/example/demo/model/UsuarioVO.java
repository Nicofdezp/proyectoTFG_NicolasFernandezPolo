package com.example.demo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "Usuario")
public class UsuarioVO {

    @Id
    private String id;
    private String nombre_usuario;
    private String email;
    private String password;
}
