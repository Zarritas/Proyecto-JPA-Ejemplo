package com.jesuslorenzo.proyecto_jpa_ejemplo.Model.Embebeds;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Embeddable
@AllArgsConstructor @NoArgsConstructor @Data
public class Periodo {
    @Column(name = "fecha_inicio")
    LocalDate fechaInicio;
    @Column(name = "fecha_final")
    LocalDate fechaFin;
}