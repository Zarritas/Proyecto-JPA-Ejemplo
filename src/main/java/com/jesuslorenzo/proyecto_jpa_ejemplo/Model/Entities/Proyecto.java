package com.jesuslorenzo.proyecto_jpa_ejemplo.Model.Entities;

import com.jesuslorenzo.proyecto_jpa_ejemplo.Model.Embebeds.Periodo;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@NoArgsConstructor @AllArgsConstructor @Data
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proy")
    private Long id;

    private String nombre;
    private String numero;

    @Embedded
    Periodo periodo;

    @ManyToMany(mappedBy = "listaProyectosTrabajan")
    private Set<Empleado> listaEmpleadosTrabajan;

    @ManyToMany(mappedBy = "listaProyectosDirigen")
    private Set<Empleado> listaEmpleadosDirigen;
}