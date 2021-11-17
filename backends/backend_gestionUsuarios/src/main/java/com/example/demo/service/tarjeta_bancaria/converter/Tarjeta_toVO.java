package com.example.demo.service.tarjeta_bancaria.converter;

import com.example.demo.model.tarjeta_bancaria.TarjetaDTO;
import com.example.demo.model.tarjeta_bancaria.TarjetaVO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class Tarjeta_toVO implements Converter<TarjetaDTO, TarjetaVO> {
    @Override
    public TarjetaVO convert(TarjetaDTO tarjeta) {
        return TarjetaVO.builder()
                .id(tarjeta.getId())
                .id_usuario(tarjeta.getId_usuario())
                .numero_tajeta(tarjeta.getNumero_tajeta())
                .saldo_tarjeta(tarjeta.getSaldo_tarjeta())
                .build();
    }
}
