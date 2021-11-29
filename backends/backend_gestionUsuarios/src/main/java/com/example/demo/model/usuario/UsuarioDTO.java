package com.example.demo.model.usuario;

import lombok.*;

import java.util.Date;

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
    private String nombre_completo;
    private String fecha_nacimiento;
    private String tarjeta_bancaria;
    private boolean trabajador;

}
