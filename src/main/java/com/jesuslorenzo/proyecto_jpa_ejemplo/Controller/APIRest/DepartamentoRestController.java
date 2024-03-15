package com.jesuslorenzo.proyecto_jpa_ejemplo.Controller.APIRest;

import com.jesuslorenzo.proyecto_jpa_ejemplo.Model.Entities.Departamento;
import com.jesuslorenzo.proyecto_jpa_ejemplo.Repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@Controller
@CrossOrigin("*")
@RequestMapping("departamento")
public class DepartamentoRestController {
    @Autowired
    DepartamentoRepository departamentoRepository;

    @GetMapping("listado")
    public List<Departamento> listadoDepartamentos(){
        return departamentoRepository.findAll();
    }

    @GetMapping("listado-por-id/{id}")
    public Optional<Departamento> listadoDepartamentos(@PathVariable long id){
        return departamentoRepository.findById(id);
    }

    @GetMapping("listado-por-localidad/{localidad}")
    public List<Departamento> findByLocalidad(@PathVariable String localidad){
        return departamentoRepository.findByLocalidad(localidad);
    }

    @GetMapping("listado-por-nombre/{nombre}")
    public List<Departamento> findByNombre(@PathVariable String nombre){
        return departamentoRepository.findByNombre(nombre);
    }

    @PostMapping("insercion-datos-departamento/{numero}/nombre/{nombre}/localidad/{localidad}/fecha-Creacion/{fechaCreacion}")
    public void insercionDatos(@PathVariable long numero,
                               @PathVariable String nombre,
                               @PathVariable String localidad,
                               @PathVariable LocalDate fechaCreacion) {
        Departamento dept = new Departamento();
        dept.setNumero(numero);
        dept.setNombre(nombre);
        dept.setLocalidad(localidad);
        dept.setFechaCreacion(fechaCreacion);
        departamentoRepository.save(dept);
    }

    @Modifying
    @PutMapping("actualizar-por-id/{id}/localidad/{localidad}")
    public void actualizarDepartamento(@PathVariable long id, @PathVariable String localidad){
        Optional<Departamento> dept = departamentoRepository.findById(id);
        if(dept.isPresent())
            dept.get().setLocalidad(localidad);
        departamentoRepository.save(dept.get());
    }

    @DeleteMapping("borrar-por-id/{id}")
    public void borrarDepartamento(@PathVariable long id){
        departamentoRepository.deleteById(id);
    }

    @DeleteMapping("aniquilacion")
    public void aniquilarDepartamentos(){
        departamentoRepository.deleteAll();
    }
}
