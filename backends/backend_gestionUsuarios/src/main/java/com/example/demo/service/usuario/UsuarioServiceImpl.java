package com.example.demo.service.usuario;

import com.example.demo.model.loginResponse.LoginResponse;
import com.example.demo.model.tarjeta_bancaria.TarjetaDTO;
import com.example.demo.model.usuario.UsuarioDTO;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.tarjeta_bancaria.TarjetaService;
import com.example.demo.service.usuario.converter.Usuario_toDTO;
import com.example.demo.service.usuario.converter.Usuario_toVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {


    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TarjetaService tarjetaService;

    @Autowired
    private Usuario_toDTO converter_toDTO;

    @Autowired
    private Usuario_toVO converter_toVO;

    @Override
    public LoginResponse loginUsuario(String user_name, String password) {

        LoginResponse loginResponse = new LoginResponse();

        UsuarioDTO usuarioDTO = this.getByUserName(user_name);

        loginResponse.setSuccess(password.equals(usuarioDTO.getPassword()));
        loginResponse.setUser(usuarioDTO);

        return loginResponse;
    }

    @Override
    public UsuarioDTO cambiarContra(String id, Map<String, String> password) {
        UsuarioDTO usuarioDTO = converter_toDTO.convert(usuarioRepository.findById(id).get());

        usuarioDTO.setPassword(password.get("password"));

        return converter_toDTO.convert(usuarioRepository.save(converter_toVO.convert(usuarioDTO)));
    }

    @Override
    public UsuarioDTO cambiarDatos(String id, Map<String, String> datos) {
        UsuarioDTO usuarioDTO = converter_toDTO.convert(usuarioRepository.findById(id).get());

        usuarioDTO.setNombre_usuario(datos.get("nombre_usuario"));
        usuarioDTO.setEmail(datos.get("email"));
        usuarioDTO.setNombre_completo(datos.get("nombre_completo"));

        System.out.println(datos.get("fecha_nacimiento"));
        usuarioDTO.setFecha_nacimiento(datos.get("fecha_nacimiento").split(" ")[0]);




        return converter_toDTO.convert(usuarioRepository.save(converter_toVO.convert(usuarioDTO)));
    }

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

        List<UsuarioDTO> cosa = usuarioRepository.findAll()
                .stream()
                .map(converter_toDTO::convert)
                .collect(Collectors.toList());

        for(UsuarioDTO usuarioDTO : cosa) {
            if(usuarioDTO.getId().equals(id)) {
                if(usuarioDTO.getTarjeta_bancaria().length() != 0) {
                    tarjetaService.removeUserCard(usuarioDTO.getTarjeta_bancaria());
                }
            }
        }
        try{
            usuarioRepository.deleteById(id);
            return Boolean.TRUE;
        }catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    @Override
    public boolean deleteAll() {

        List<UsuarioDTO> cosa = usuarioRepository.findAll()
                .stream()
                .map(converter_toDTO::convert)
                .collect(Collectors.toList());

        for(UsuarioDTO usuarioDTO : cosa) {
            if(usuarioDTO.getTarjeta_bancaria().length() != 0) {
                tarjetaService.removeUserCard(usuarioDTO.getTarjeta_bancaria());
            }
        }

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

    @Override
    public String getTarjeta_user(String id) {
        return converter_toDTO.convert(usuarioRepository.findById(id).get()).getTarjeta_bancaria();
    }

    @Override
    public UsuarioDTO introducir_Tarjeta(String id_usuario, String numero_tajeta) {

        TarjetaDTO tarjetaDTO = TarjetaDTO.builder()
                .id_usuario(id_usuario)
                .numero_tajeta(numero_tajeta)
                .saldo_tarjeta(1500.50)
                .build();

        UsuarioDTO usuarioDTO = converter_toDTO.convert(usuarioRepository.findById(id_usuario).get());

        usuarioDTO.setTarjeta_bancaria(tarjetaService.getCard_byId(tarjetaService.create(tarjetaDTO).getId()).getId());


        return converter_toDTO.convert(usuarioRepository.save(converter_toVO.convert(usuarioDTO)));
    }
}
