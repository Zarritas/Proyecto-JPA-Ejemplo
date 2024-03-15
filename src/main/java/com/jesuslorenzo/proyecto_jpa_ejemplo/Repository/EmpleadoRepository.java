package com.jesuslorenzo.proyecto_jpa_ejemplo.Repository;

        import com.jesuslorenzo.proyecto_jpa_ejemplo.Model.Entities.Empleado;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
}
