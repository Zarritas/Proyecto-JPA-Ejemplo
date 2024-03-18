package com.jesuslorenzo.proyecto_jpa_ejemplo.Model.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(name="UC_numero", columnNames = {"numero"})})
@AllArgsConstructor @NoArgsConstructor @Data
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_dept")
    Long id;

    Long numero;
    String nombre;
    String localidad;

    @Column(name = "fecha_creacion")
    LocalDate fechaCreacion;
}