package com.example.demo.model.loginResponse;

import com.example.demo.model.usuario.UsuarioDTO;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponse {

    private Boolean success;
    private UsuarioDTO user;

}
