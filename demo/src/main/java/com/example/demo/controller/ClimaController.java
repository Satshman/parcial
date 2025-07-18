package com.example.demo.controller;

import com.example.demo.model.Clima;
import com.example.demo.model.Ciudad;
import com.example.demo.service.ClimaService;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/v1/clima")
public class ClimaController {

    private final ClimaService climaService;

    public ClimaController(ClimaService climaService) {
        this.climaService = climaService;
    }

    @GetMapping
    public List<Clima> obtenerClima(@RequestParam String ciudad,
                                    @RequestParam String pais) {
        return climaService.obtenerClimaPorCiudad(ciudad, pais);
    }

    @PostMapping("/ciudad")
    public Ciudad registrarCiudad(@RequestBody Ciudad ciudad) {
        return climaService.guardarCiudad(ciudad);
    }

    @PostMapping
    public EntityModel<Clima> registrarClima(@RequestParam String ciudad,
                                             @RequestParam String pais,
                                             @RequestBody Clima clima) {
        Clima guardado = climaService.guardarClima(ciudad, pais, clima);

        EntityModel<Clima> recurso = EntityModel.of(guardado);
        Link selfLink = linkTo(methodOn(ClimaController.class)
                .obtenerClima(ciudad, pais)).withSelfRel();
        recurso.add(selfLink);

        return recurso;
    }
}
