package com.jesuslorenzo.proyecto_jpa_ejemplo.Repository;

import com.jesuslorenzo.proyecto_jpa_ejemplo.Model.Entities.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    List<Departamento> findByLocalidad(String localidad);
    List<Departamento> findByNombre(String nombre);
}