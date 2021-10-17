package com.example.demo.service.converter;

import com.example.demo.model.UsuarioDTO;
import com.example.demo.model.UsuarioVO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class Usuario_toVO implements Converter<UsuarioDTO, UsuarioVO> {

    @Override
    public UsuarioVO convert(UsuarioDTO usuarioDTO) {
        return UsuarioVO.builder()
                .id(usuarioDTO.getId())
                .nombre_usuario(usuarioDTO.getNombre_usuario())
                .email(usuarioDTO.getEmail())
                .password(usuarioDTO.getPassword())
                .build();
    }
}
