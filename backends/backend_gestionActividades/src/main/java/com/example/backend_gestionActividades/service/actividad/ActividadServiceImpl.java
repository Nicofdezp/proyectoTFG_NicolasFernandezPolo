package com.example.backend_gestionActividades.service.actividad;

import com.example.backend_gestionActividades.model.actividad.ActividadDTO;
import com.example.backend_gestionActividades.model.material.MaterialDTO;
import com.example.backend_gestionActividades.repository.actividad.ActividadRepository;
import com.example.backend_gestionActividades.service.actividad.converter.ConverterAct_toDTO;
import com.example.backend_gestionActividades.service.actividad.converter.ConverterAct_toVO;
import com.example.backend_gestionActividades.service.material.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActividadServiceImpl implements ActividadService {

    @Autowired
    private ActividadRepository actividadRepository;

    @Autowired
    private MaterialService materialService;

    @Autowired
    private ConverterAct_toDTO converterAct_toDTO;

    @Autowired
    private ConverterAct_toVO converterAct_toVO;


    @Override
    public List<ActividadDTO> getAll() {
        return actividadRepository.findAll()
                .stream()
                .map(converterAct_toDTO::convert)
                .collect(Collectors.toList());
    }

    @Override
    public ActividadDTO getById(String id) {
        return converterAct_toDTO.convert(actividadRepository.findById(id).get());
    }

    @Override
    public List<ActividadDTO> getByType(String tipo_actividad) {

        List<ActividadDTO> aux = actividadRepository.findAll()
                .stream()
                .map(converterAct_toDTO::convert)
                .collect(Collectors.toList());

        List<ActividadDTO> aux2 = new ArrayList<>();

        for (ActividadDTO actividadDTO : aux) {
            if (tipo_actividad.equalsIgnoreCase(actividadDTO.getTipo_actividad())) {
                aux2.add(actividadDTO);
            }
        }


        return aux2;
    }

    @Override
    public List<ActividadDTO> getByDificult(String dificultad) {
        return null;
    }

    @Override
    public boolean deleteAll() {
        try {
            actividadRepository.deleteAll();
            return Boolean.TRUE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    @Override
    public boolean delete(String id) {
        try {
            actividadRepository.deleteById(id);
            return Boolean.TRUE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    @Override
    public ActividadDTO create(ActividadDTO actividad) {
        ActividadDTO actividadDTO = converterAct_toDTO.convert(actividadRepository.save(converterAct_toVO.convert(actividad)));

        try {
            return actividadDTO;
        } catch (Exception e) {
            return actividadDTO;
        }
    }

    @Override
    public List<MaterialDTO> getMaterialAct_proporcionados(String id) {

        ActividadDTO actividadDTO = converterAct_toDTO.convert(actividadRepository.findById(id).get());

        List<MaterialDTO> aux = new ArrayList<>();

        for (String codigo_act : actividadDTO.getMateriales_proporcionados()) {
            aux.add(materialService.getById(codigo_act));
        }


        for (MaterialDTO a : aux) {
            System.out.println(a.toString());
        }

        return aux;
    }

    @Override
    public boolean deleteAll_proporcinados(String id) {

        ActividadDTO actividadDTO = converterAct_toDTO.convert(actividadRepository.findById(id).get());

        try {
            actividadDTO.getMateriales_proporcionados().clear();
            actividadRepository.save(converterAct_toVO.convert(actividadDTO));
            return Boolean.TRUE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    @Override
    public boolean deleteById_proporcionados(String id, String id_mat) {

        ActividadDTO actividadDTO = converterAct_toDTO.convert(actividadRepository.findById(id).get());


        try {
            actividadDTO.getMateriales_proporcionados().remove(id_mat);

            actividadRepository.save(converterAct_toVO.convert(actividadDTO));
            return Boolean.TRUE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }
}
