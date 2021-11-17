package com.example.backend_gestionReservas.service;

import com.example.backend_gestionReservas.model.ReservaDTO;
import com.example.backend_gestionReservas.repository.ReservaRepository;
import com.example.backend_gestionReservas.service.converter.Reserva_toDTO;
import com.example.backend_gestionReservas.service.converter.Reserva_toVO;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReservaServiceImpl implements ReservaService{

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private Reserva_toDTO reserva_toDTO;

    @Autowired
    private Reserva_toVO reserva_toVO;

    @Override
    public List<ReservaDTO> getAll() {
        return reservaRepository.findAll()
                .stream()
                .map(reserva_toDTO::convert)
                .collect(Collectors.toList());
    }

    @Override
    public ReservaDTO getById(String id) {
        return reserva_toDTO.convert(reservaRepository.findById(id).get());
    }

    @Override
    public boolean deleteAll() {
        try {
            reservaRepository.deleteAll();
            return Boolean.TRUE;
        }catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    @Override
    public boolean deleteById(String id) {
        try {
            reservaRepository.deleteById(id);
            return Boolean.TRUE;
        }catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    @Override
    public ReservaDTO create(String id_actividad, String id_monitor) {

        ArrayList<String> personas_monitor = new ArrayList<>();
        personas_monitor.add(id_monitor);

        ReservaDTO reservaDTO = ReservaDTO.builder()
                .personas_finales(new ArrayList<>())
                .personas_reserva(new ArrayList<>())
                .personas_monitor(personas_monitor)
                .id_actividad(id_actividad)
                .build();


        return reserva_toDTO.convert(reservaRepository.save(reserva_toVO.convert(reservaDTO)));
    }

    @Override
    public ReservaDTO eliminarPersona(String id_reserva, String id_usuario) {

        ReservaDTO reservaDTO = reserva_toDTO.convert(reservaRepository.findById(id_reserva).get());

        reservaDTO.getPersonas_finales().remove(id_usuario);
        reservaDTO.getPersonas_reserva().remove(id_usuario);
        reservaDTO.getPersonas_monitor().remove(id_usuario);


        return reserva_toDTO.convert(reservaRepository.save(reserva_toVO.convert(reservaDTO)));
    }

    @Override
    public ReservaDTO realizarPago(String id_actividad, String id_usuario) {

        String baseURL = "http://localhost:8085/usuario/"+id_usuario;
        String baseURL2 = "http://localhost:8085/actividad/"+id_actividad;

        ReservaDTO reservaDTO = getRerserva_byActivity(id_actividad);

        RestTemplate restTemplate = new RestTemplate();
        String datos_usuario,datos_actividad,datos_tarjeta,tarjetaUsuario = "", id_reserva = "";
        double saldoTarjeta = 0.0, precioActividad = 0.0;

        try {

            datos_usuario = restTemplate.getForObject(baseURL, String.class);

            JSONObject usu = (JSONObject) XML.toJSONObject(datos_usuario).get("UsuarioDTO");
            tarjetaUsuario = usu.get("tarjeta_bancaria").toString();
        }catch (Exception e) {
            e.printStackTrace();
        }

        if(tarjetaUsuario.length() != 0){
            String baseURL3 = "http://localhost:8085/usuario/tarjeta/"+tarjetaUsuario;

            try{
                datos_tarjeta = restTemplate.getForObject(baseURL3, String.class);

                JSONObject tarj = (JSONObject) XML.toJSONObject(datos_tarjeta).get("TarjetaDTO");
                saldoTarjeta = Double.parseDouble(tarj.get("saldo_tarjeta").toString());

            }catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("Fallo con la tarjeta usuario");
        }

        try{
            datos_actividad = restTemplate.getForObject(baseURL2, String.class);

            JSONObject act = (JSONObject) XML.toJSONObject(datos_actividad).get("ActividadDTO");
            precioActividad = Double.parseDouble(act.get("precio").toString());

        }catch (Exception e) {
            e.printStackTrace();
        }

        if(saldoTarjeta >= precioActividad) {
            String baseURL3 = "http://localhost:8085/usuario/tarjeta/" + id_usuario +"/restar/"+precioActividad;
            restTemplate.put(baseURL3, HttpMethod.PUT);

            reservaDTO.getPersonas_reserva().remove(id_usuario);
            reservaDTO.getPersonas_finales().add(id_usuario);
        }


        return reserva_toDTO.convert(reservaRepository.save(reserva_toVO.convert(reservaDTO)));
    }

    @Override
    public ReservaDTO introducir_monitor(String id_actividad, String id_monitor) {

        ReservaDTO reservaDTO = getRerserva_byActivity(id_actividad);

        RestTemplate restTemplate = new RestTemplate();
        String baseURL = "http://localhost:8085/actividad/"+id_actividad;
        String datos_actividad;
        int monitores_max = 0;

        try{

            datos_actividad = restTemplate.getForObject(baseURL, String.class);

            JSONObject act = (JSONObject) XML.toJSONObject(datos_actividad).get("ActividadDTO");
            monitores_max = Integer.parseInt(act.get("capacidad_monitor").toString());
        }catch (Exception e) {
            e.printStackTrace();
        }

        if(reservaDTO.getPersonas_monitor().size() < monitores_max) {
            reservaDTO.getPersonas_monitor().add(id_monitor);
        }else{
            System.out.println("numero max de monitores alcanzado");
        }

        return reserva_toDTO.convert(reservaRepository.save(reserva_toVO.convert(reservaDTO)));
    }

    @Override
    public Boolean pagoCheck(String id_actividad, String id_usuario) {

        ReservaDTO reservaDTO = getRerserva_byActivity(id_actividad);

        boolean pago_realizado;

        if(reservaDTO.getPersonas_reserva().contains(id_usuario)){
            pago_realizado = false;
        }else {
            pago_realizado = reservaDTO.getPersonas_finales().contains(id_usuario);
        }

        return pago_realizado;
    }

    @Override
    public ReservaDTO getRerserva_byActivity(String id_actividad) {

        List<ReservaDTO> reservas = reservaRepository.findAll()
                .stream()
                .map(reserva_toDTO::convert)
                .collect(Collectors.toList());

        ReservaDTO la_reserva = null;

        for(ReservaDTO reservaDTO : reservas) {
            if(reservaDTO.getId_actividad().equals(id_actividad)){
                la_reserva = reservaDTO;
            }
        }

        return la_reserva;
    }

    @Override
    public List<ReservaDTO> getReservas_usuario(String id_usuario) {
        return null;
    }

    @Override
    public ReservaDTO realizarReserva(String id_actividad, String id_usuario) {

        ReservaDTO reservaDTO = getRerserva_byActivity(id_actividad);

        if(reservaDTO != null){
            reservaDTO.getPersonas_reserva().add(id_usuario);
        }

        return reserva_toDTO.convert(reservaRepository.save(reserva_toVO.convert(reservaDTO)));
    }
}
