package com.jesuslorenzo.proyecto_jpa_ejemplo.Controller.APIRest;

import com.jesuslorenzo.proyecto_jpa_ejemplo.Model.Entities.Proyecto;
import com.jesuslorenzo.proyecto_jpa_ejemplo.Repository.ProyectoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("proyectos")
public class ProyectoRestController {
    @Autowired
    ProyectoRepository proyectoRepository;

    @GetMapping("listado")
    public List<Proyecto> listadoProyectos(){
        return proyectoRepository.findAll();
    }

}
