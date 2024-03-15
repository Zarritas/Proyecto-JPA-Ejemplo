package com.jesuslorenzo.proyecto_jpa_ejemplo.Model.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@NoArgsConstructor @AllArgsConstructor @Data
public class Empleado {
    @Id
    @Column(name = "id_emp")
    Long id;

    String nombre;
    String cargo;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_EMP_MGR"))
    Empleado jefe;
    @Column(name = "fecha_contratacion")
    LocalDate fechaContratacion;
    @Column(precision = 7, scale = 2)
    BigDecimal salario;
    @Column(precision = 7, scale = 2)
    BigDecimal comision;
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_DEPT_EMP"))
    Departamento departamento;
    @ManyToMany
    @JoinTable(name = "Proyecto_empleado",
            joinColumns = @JoinColumn(name = "id_emp",
                    foreignKey = @ForeignKey(name = "FK_PROY_EMP")),
            inverseJoinColumns = @JoinColumn(name = "id_proy",
                    foreignKey = @ForeignKey(name = "FK_PROY_PROY")))
    private Set<Proyecto> listaProyectosTrabajan;
    @ManyToMany
    @JoinTable(name = "Proyecto_Empleado",
            joinColumns = @JoinColumn(name = "id_emp",
                    foreignKey = @ForeignKey(name = "FK_PROY_EMP")),
            inverseJoinColumns = @JoinColumn(name = "id_proy",
                    foreignKey = @ForeignKey(name = "FK_PROY_PROY")))
    private Set<Proyecto> listaProyectosDirigen;
}