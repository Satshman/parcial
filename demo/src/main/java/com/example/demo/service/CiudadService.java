package com.example.demo.service;

import com.example.demo.model.Ciudad;
import com.example.demo.repository.CiudadRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CiudadService {
    private final
    CiudadRepository ciudadRepository;

    public CiudadService(CiudadRepository ciudadRepository) {
        this.ciudadRepository = ciudadRepository;
    }

    public List<Ciudad> obtenerTodas() {
        return ciudadRepository.findAll();
    }

    public Optional<Ciudad> buscarPorNombreYPais(String nombre, String pais) {
        return ciudadRepository.findByNombreAndPais(nombre, pais);
    }

    public Ciudad guardar(Ciudad ciudad) {
        return ciudadRepository.save(ciudad);
    }

    public Optional<Ciudad> obtenerPorId(Long id) {
        return ciudadRepository.findById(id);
    }

    public void eliminarPorId(Long id) {
        ciudadRepository.deleteById(id);
    }

}
