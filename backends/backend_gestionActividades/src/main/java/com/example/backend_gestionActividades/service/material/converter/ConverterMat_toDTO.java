package com.example.backend_gestionActividades.service.material.converter;

import com.example.backend_gestionActividades.model.material.MaterialDTO;
import com.example.backend_gestionActividades.model.material.MaterialVO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ConverterMat_toDTO implements Converter<MaterialVO, MaterialDTO> {

    @Override
    public MaterialDTO convert(MaterialVO material) {
        return MaterialDTO.builder()
                .id(material.getId())
                .nombre_material(material.getNombre_material())
                .build();
    }
}
