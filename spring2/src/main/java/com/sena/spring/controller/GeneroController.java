package com.sena.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.sena.spring.model.Genero;
import com.sena.spring.model.IGenero;


@Controller
@SessionAttributes("genero")
@RequestMapping("/genero")
public class GeneroController {

    @Autowired
    private IGenero generod;

    @GetMapping(path={"/listar","","/"})
    public String listar(Model m) {
        m.addAttribute("generos", generod.findAll());
        return "genero/listar";
    }

    @GetMapping("/ver")
    public String verc(Model m){
        Genero gen=new Genero();
        gen.setId(1);
        gen.setNombre_genero("Lina");
        gen.setEstado_genero(false); 
        m.addAttribute("genero", gen);
        return "genero/ver";
    }

    /*@GetMapping("/ver")
    public String ver(@RequestParam int id,String nombreGenero,Model m){
        m.addAttribute("msn", "En la ruta llegó el id "+id+" y el nombre recibido es "+nombreGenero);
        return "genero/ver";
    }*/

    @GetMapping(path={"/ver/{id}"})
    public String ver(@PathVariable int id, Model m){
        Genero genero=null;
        if(id>0){
            genero=generod.findOne(id);
        }else{
            return "redirect:listar";
        }
        m.addAttribute("genero", genero);
        m.addAttribute("accion", "Actualizar Genero");
        return "genero/form";
    }
    
    @GetMapping(path={"/form"})
    public String form(Model m) {
        Genero genero=new Genero();
        m.addAttribute("genero", genero);
        m.addAttribute("accion", "Agregar Genero");
        return "genero/form";
    }

    @PostMapping("/add")
    public String add(@Valid Genero genero, BindingResult res, Model m, SessionStatus status) {
        if(res.hasErrors()){
            return "genero/form";
        }
        /*m.addAttribute("genero", genero);
        return "genero/ver";*/
        generod.save(genero);
        status.setComplete();
        return "redirect:listar";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        if(id>0){
            generod.delete(id);
        }
        return "redirect:../listar";
    }
    
    
}
