package com.example.demo.model;

import lombok.*;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class UsuarioDTO {

    private String id;
    private String nombre_usuario;
    private String email;
    private String password;

}
