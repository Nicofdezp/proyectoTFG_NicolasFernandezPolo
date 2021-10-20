package com.example.backend_gestionActividades.service.material.converter;

import com.example.backend_gestionActividades.model.material.MaterialDTO;
import com.example.backend_gestionActividades.model.material.MaterialVO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ConverterMat_toVO implements Converter<MaterialDTO, MaterialVO> {
    @Override
    public MaterialVO convert(MaterialDTO material) {
        return MaterialVO.builder()
                .id(material.getId())
                .nombre_material(material.getNombre_material())
                .build();
    }
}
