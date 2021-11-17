package com.example.demo.model.tarjeta_bancaria;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class TarjetaDTO {

    private String id;
    private String id_usuario;
    private String numero_tajeta;
    private Double saldo_tarjeta;
}
