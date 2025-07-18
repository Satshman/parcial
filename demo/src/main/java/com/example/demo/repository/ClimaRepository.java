package com.example.demo.repository;

import com.example.demo.model.Clima;
import com.example.demo.model.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClimaRepository extends JpaRepository<Clima, Long> {
    List<Clima> findByCiudad(Ciudad ciudad);
}