package com.example.demo.controller;

import com.example.demo.model.Ciudad;
import com.example.demo.service.CiudadService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/ciudades")

public class CiudadController {
    private final CiudadService ciudadService;

    public CiudadController(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    @GetMapping
    public List<Ciudad> obtenerTodas() {
        return ciudadService.obtenerTodas();
    }

    @GetMapping("/buscar")
    public Optional<Ciudad> buscarPorNombreYPais(@RequestParam String nombre, @RequestParam String pais) {
        return ciudadService.buscarPorNombreYPais(nombre, pais);
    }

    @PostMapping
    public Ciudad crearCiudad(@RequestBody Ciudad ciudad) {
        return ciudadService.guardar(ciudad);
    }

    @GetMapping("/{id}")
    public Optional<Ciudad> obtenerPorId(@PathVariable Long id) {
        return ciudadService.obtenerPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarPorId(@PathVariable Long id) {
        ciudadService.eliminarPorId(id);
    }
}
