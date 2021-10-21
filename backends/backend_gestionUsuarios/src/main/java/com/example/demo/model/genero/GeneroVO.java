package com.example.demo.model.genero;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "Genero")
public class GeneroVO {

    @Id
    private String id;
    private String genero;
}
