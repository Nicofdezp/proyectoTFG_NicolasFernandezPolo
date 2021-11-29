package com.example.demo.service.usuario.converter;

import com.example.demo.model.usuario.UsuarioDTO;
import com.example.demo.model.usuario.UsuarioVO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class Usuario_toVO implements Converter<UsuarioDTO, UsuarioVO> {

    @Override
    public UsuarioVO convert(UsuarioDTO usuario) {
        return UsuarioVO.builder()
                .id(usuario.getId())
                .nombre_usuario(usuario.getNombre_usuario())
                .email(usuario.getEmail())
                .password(usuario.getPassword())
                .nombre_completo(usuario.getNombre_completo())
                .fecha_nacimiento(usuario.getFecha_nacimiento())
                .tarjeta_bancaria(usuario.getTarjeta_bancaria())
                .trabajador(usuario.isTrabajador())
                .build();
    }
}
