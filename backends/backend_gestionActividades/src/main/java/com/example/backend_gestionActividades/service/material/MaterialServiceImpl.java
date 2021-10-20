package com.example.backend_gestionActividades.service.material;

import com.example.backend_gestionActividades.model.material.MaterialDTO;
import com.example.backend_gestionActividades.repository.material.MaterialRepository;
import com.example.backend_gestionActividades.service.material.converter.ConverterMat_toDTO;
import com.example.backend_gestionActividades.service.material.converter.ConverterMat_toVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private ConverterMat_toVO converterMat_toVO;

    @Autowired
    private ConverterMat_toDTO converterMat_toDTO;


    @Override
    public List<MaterialDTO> getAll() {
        return materialRepository.findAll()
                .stream()
                .map(converterMat_toDTO::convert)
                .collect(Collectors.toList());
    }

    @Override
    public MaterialDTO getById(String id) {
        return converterMat_toDTO.convert(materialRepository.findById(id).get());
    }

    @Override
    public Boolean deleteAll() {
        try{
            materialRepository.deleteAll();
            return Boolean.TRUE;
        }catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    @Override
    public Boolean deleteById(String id) {
        try{
            materialRepository.deleteById(id);
            return Boolean.TRUE;
        }catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    @Override
    public MaterialDTO create(MaterialDTO material) {

        MaterialDTO materialDTO = converterMat_toDTO.convert(materialRepository.save(converterMat_toVO.convert(material)));


        try {
            return materialDTO;
        }catch (Exception e) {
            return materialDTO;
        }
    }
}
