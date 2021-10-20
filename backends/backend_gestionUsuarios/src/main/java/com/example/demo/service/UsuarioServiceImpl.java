package com.example.demo.service;

import com.example.demo.model.UsuarioDTO;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.converter.Usuario_toDTO;
import com.example.demo.service.converter.Usuario_toVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {


    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private Usuario_toDTO converter_toDTO;

    @Autowired
    private Usuario_toVO converter_toVO;

    @Override
    public List<UsuarioDTO> getAll() {
        return usuarioRepository.findAll()
                .stream()
                .map(converter_toDTO::convert)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO getById(String id) {
        return converter_toDTO.convert(usuarioRepository.findById(id).get());
    }

    @Override
    public UsuarioDTO getByUserName(String nombre_usuario) {

        UsuarioDTO aux = new UsuarioDTO();

        List<UsuarioDTO> cosa = usuarioRepository.findAll()
                .stream()
                .map(converter_toDTO::convert).filter(Objects::nonNull)
                .collect(Collectors.toList());

        for(UsuarioDTO usuarioDTO : cosa) {
            if(nombre_usuario.equalsIgnoreCase(usuarioDTO.getNombre_usuario())) {
                aux = usuarioDTO;
                break;
            }else {
                aux = null;
            }
        }
        return aux;
    }


    @Override
    public boolean delete(String id) {
        try{
            usuarioRepository.deleteById(id);
            return Boolean.TRUE;
        }catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    @Override
    public boolean deleteAll() {
        try{
            usuarioRepository.deleteAll();
            return Boolean.TRUE;
        }catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    @Override
    public UsuarioDTO create(UsuarioDTO usuario) {
        UsuarioDTO usuarioDTO = converter_toDTO.convert(usuarioRepository.save(converter_toVO.convert(usuario)));

        try{
            return usuarioDTO;
        }catch (Exception e) {
            return usuarioDTO;
        }
    }
}
