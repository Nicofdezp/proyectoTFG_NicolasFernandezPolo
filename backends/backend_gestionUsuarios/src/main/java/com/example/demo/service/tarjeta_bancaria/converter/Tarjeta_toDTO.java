package com.example.demo.service.tarjeta_bancaria.converter;

import com.example.demo.model.tarjeta_bancaria.TarjetaDTO;
import com.example.demo.model.tarjeta_bancaria.TarjetaVO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Tarjeta_toDTO implements Converter<TarjetaVO, TarjetaDTO> {
    @Override
    public TarjetaDTO convert(TarjetaVO tarjeta) {
        return TarjetaDTO.builder()
                .id(tarjeta.getId())
                .id_usuario(tarjeta.getId_usuario())
                .numero_tajeta(tarjeta.getNumero_tajeta())
                .saldo_tarjeta(tarjeta.getSaldo_tarjeta())
                .build();
    }


}
