package com.jesuslorenzo.proyecto_jpa_ejemplo.Repository;

import com.jesuslorenzo.proyecto_jpa_ejemplo.Model.Entities.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
}
