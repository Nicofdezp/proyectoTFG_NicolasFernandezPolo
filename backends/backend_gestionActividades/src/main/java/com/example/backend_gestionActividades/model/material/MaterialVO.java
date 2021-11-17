package com.example.backend_gestionActividades.model.material;

import lombok.*;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Document(collection = "Material")
public class MaterialVO {

    @Id
    private String id;
    private String nombre_material;
}
