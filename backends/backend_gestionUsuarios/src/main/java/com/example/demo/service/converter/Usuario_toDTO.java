package com.example.demo.service.converter;


import com.example.demo.model.UsuarioDTO;
import com.example.demo.model.UsuarioVO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class Usuario_toDTO implements Converter<UsuarioVO, UsuarioDTO> {

    @Override
    public UsuarioDTO convert(UsuarioVO usuarioVO) {
        return UsuarioDTO.builder()
                .id(usuarioVO.getId())
                .nombre_usuario(usuarioVO.getNombre_usuario())
                .email(usuarioVO.getEmail())
                .password(usuarioVO.getPassword())
                .build();
    }
}
