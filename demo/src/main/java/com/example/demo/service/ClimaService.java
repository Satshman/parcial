package com.example.demo.service;

import com.example.demo.model.Ciudad;
import com.example.demo.model.Clima;
import com.example.demo.repository.CiudadRepository;
import com.example.demo.repository.ClimaRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ClimaService {

    private final CiudadRepository ciudadRepo;
    private final ClimaRepository climaRepo;

    public ClimaService(CiudadRepository ciudadRepo, ClimaRepository climaRepo) {
        this.ciudadRepo = ciudadRepo;
        this.climaRepo = climaRepo;
    }

    public Ciudad guardarCiudad(Ciudad ciudad) {
        return ciudadRepo.save(ciudad);
    }

    public Clima guardarClima(String nombreCiudad, String pais, Clima clima) {
        Ciudad ciudad = ciudadRepo.findByNombreAndPais(nombreCiudad, pais)
                .orElseThrow(() -> new RuntimeException("Ciudad no encontrada"));
        clima.setCiudad(ciudad);
        return climaRepo.save(clima);
    }

    public List<Clima> obtenerClimaPorCiudad(String nombreCiudad, String pais) {
        Ciudad ciudad = ciudadRepo.findByNombreAndPais(nombreCiudad, pais)
                .orElseThrow(() -> new RuntimeException("Ciudad no encontrada"));
        return climaRepo.findByCiudad(ciudad);
    }
}