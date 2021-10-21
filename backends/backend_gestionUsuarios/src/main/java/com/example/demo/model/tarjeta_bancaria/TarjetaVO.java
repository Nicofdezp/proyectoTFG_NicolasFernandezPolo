package com.example.demo.model.tarjeta_bancaria;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Document(collection = "Tarjeta_bancaria")
public class TarjetaVO {

    @Id
    private String id;
    private String id_usuario;
    private String numero_tajeta;
    private Double saldo_tarjeta;
}
