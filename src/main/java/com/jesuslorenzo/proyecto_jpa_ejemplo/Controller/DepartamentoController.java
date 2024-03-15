package com.jesuslorenzo.proyecto_jpa_ejemplo.Controller;

import com.jesuslorenzo.proyecto_jpa_ejemplo.Model.Entities.Departamento;
import com.jesuslorenzo.proyecto_jpa_ejemplo.Repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("departamentos")
public class DepartamentoController {
    @Autowired
    DepartamentoRepository departamentoRepository;
    @GetMapping("listado-departamentos")
    public ModelAndView listadoDepartamentos(Model modelo){
        ModelAndView modelAndView = new ModelAndView("AllDepts");
        List<Departamento> departamentos = departamentoRepository.findAll();
        modelAndView.addObject("departamentos",departamentos);
        return modelAndView;
    }
    @GetMapping("listado-departamentos-ajax")
    public ModelAndView listadoDepartamentosAjax(){
        return new ModelAndView("AllDeptsAjax");
    }
    @GetMapping("detalle/{id}")
    public ModelAndView detalleDepartamento(@PathVariable Long id,
                                            Model modelo,
                                            @RequestParam boolean editable,
                                            @RequestParam(required = false) boolean correcto){
        if(correcto){
            modelo.addAttribute("correcto",correcto);
        }
        ModelAndView modelAndView = new ModelAndView("OneDept");
        Optional<Departamento> departamento = departamentoRepository.findById(id);
        modelAndView.addObject("editable",editable);
        if (departamento.isPresent())
            modelAndView.addObject("departamento",departamento.get());
        return modelAndView;
    }
    @GetMapping("borrar/{id}")
    public String borrarDepartamento(@PathVariable Long id){
        departamentoRepository.deleteById(id);
        return "redirect:/departamentos/listadoDepartamentos";
    }
    @PostMapping("actualizar/{id}")
    public String actualizarDepartamento(@PathVariable Long id,
                                         @RequestParam String numero,
                                         @RequestParam String nombre,
                                         @RequestParam LocalDate fechaCreacion,
                                         @RequestParam String localidad){
        Optional<Departamento> dept = departamentoRepository.findById(id);
        if(dept.isPresent()) {
            dept.get().setNumero(Long.valueOf(numero));
            dept.get().setNombre(nombre);
            dept.get().setLocalidad(localidad);
            dept.get().setFechaCreacion(fechaCreacion);
            departamentoRepository.save(dept.get());
        }
        return "redirect:/departamentos/detalle/"+id+"?editable=false&correcto=true";
    }
}
