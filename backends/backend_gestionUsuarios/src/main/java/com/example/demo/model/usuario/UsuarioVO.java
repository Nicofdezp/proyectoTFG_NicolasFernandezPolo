package com.example.demo.model.usuario;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

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
    private String nombre_completo;
    private String fecha_nacimiento;
    private String genero;
    private String tarjeta_bancaria;
    private boolean trabajador;
}
