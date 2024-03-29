package com.jesuslorenzo.proyecto_jpa_ejemplo.Controller;

import com.jesuslorenzo.proyecto_jpa_ejemplo.Model.Entities.Departamento;
import com.jesuslorenzo.proyecto_jpa_ejemplo.Repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public ModelAndView listadoDepartamentos(){
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
                                            @RequestParam(required = false) boolean editable,
                                            @RequestParam(required = false) boolean correcto){
        ModelAndView modelAndView = new ModelAndView("OneDept");
        Optional<Departamento> departamento = departamentoRepository.findById(id);

        if(correcto) modelAndView.addObject("correcto", true);

        if (editable) modelAndView.addObject("editable", true);

        departamento.ifPresent(value -> modelAndView.addObject("departamento", value));

        return modelAndView;
    }
    @GetMapping("borrar/{id}")
    public String borrarDepartamento(@PathVariable Long id){
        departamentoRepository.deleteById(id);
        return "redirect:/departamentos/listado-departamentos";
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
            return "redirect:/departamentos/detalle/"+id+"?correcto=true";
        }
        return "redirect:/departamentos/detalle/"+id;
    }
}
