package com.example.demo.service.tarjeta_bancaria;

import com.example.demo.model.tarjeta_bancaria.TarjetaDTO;
import com.example.demo.model.usuario.UsuarioDTO;

public interface TarjetaService {

    boolean removeUserCard(final String id_tarjeta);

    TarjetaDTO create(final TarjetaDTO tarjetaDTO);

    TarjetaDTO getCard_User(final String id_usuario);

    UsuarioDTO getUser_Card(final String id_tarjeta);

    boolean restarSaldo(final Double precio);

    boolean sumarSaldo(final Double precio);

    TarjetaDTO getCard_byId(final String id);


}
