package com.example.demo.service.tarjeta_bancaria;

import com.example.demo.model.tarjeta_bancaria.TarjetaDTO;
import com.example.demo.model.usuario.UsuarioDTO;
import com.example.demo.repository.TarjetaRepository;
import com.example.demo.service.tarjeta_bancaria.converter.Tarjeta_toDTO;
import com.example.demo.service.tarjeta_bancaria.converter.Tarjeta_toVO;
import com.example.demo.service.usuario.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarjetaServiceImpl implements TarjetaService{

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TarjetaRepository tarjetaRepository;

    @Autowired
    private Tarjeta_toDTO converter_toDTO;

    @Autowired
    private Tarjeta_toVO converter_toVO;



    @Override
    public boolean removeUserCard(String id_usuario) {

        UsuarioDTO usuarioDTO = usuarioService.getById(id_usuario);

        try{
            usuarioDTO.setTarjeta_bancaria("");
            return Boolean.TRUE;
        }catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    @Override
    public TarjetaDTO create(TarjetaDTO tarjetaDTO) {
        return converter_toDTO.convert(tarjetaRepository.save(converter_toVO.convert(tarjetaDTO)));
    }

    @Override
    public TarjetaDTO getCard_User(String id_usuario) {

        return converter_toDTO.convert(tarjetaRepository.findById(usuarioService.getTarjeta_user(id_usuario)).get());
    }

    @Override
    public UsuarioDTO getUser_Card(String id_tarjeta) {

        return usuarioService.getById(tarjetaRepository.findById(id_tarjeta).get().getId_usuario());
    }

    @Override
    public TarjetaDTO restarSaldo(String id, String precio) {

        UsuarioDTO usuarioDTO = usuarioService.getById(id);

        TarjetaDTO tarjetaDTO = converter_toDTO.convert(tarjetaRepository.findById(usuarioDTO.getTarjeta_bancaria()).get());

        Double saldo = Double.parseDouble(precio);

        tarjetaDTO.setSaldo_tarjeta(tarjetaDTO.getSaldo_tarjeta() - saldo);

        return converter_toDTO.convert(tarjetaRepository.save(converter_toVO.convert(tarjetaDTO)));
    }

    @Override
    public TarjetaDTO sumarSaldo(String id, String precio) {

        UsuarioDTO usuarioDTO = usuarioService.getById(id);

        TarjetaDTO tarjetaDTO = converter_toDTO.convert(tarjetaRepository.findById(usuarioDTO.getTarjeta_bancaria()).get());


        Double saldo = Double.parseDouble(precio);

        tarjetaDTO.setSaldo_tarjeta(tarjetaDTO.getSaldo_tarjeta() + saldo);

        return converter_toDTO.convert(tarjetaRepository.save(converter_toVO.convert(tarjetaDTO)));
    }

    @Override
    public TarjetaDTO getCard_byId(String id) {
        return converter_toDTO.convert(tarjetaRepository.findById(id).get());
    }
}
