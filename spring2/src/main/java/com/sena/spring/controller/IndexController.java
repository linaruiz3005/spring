package com.sena.spring.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @GetMapping(path = {"/index"})
    
    public ModelAndView index(ModelAndView m){
        m.addObject("msn", "Este mensaje viene del controlador");
        m.setViewName("index");
        return m;
    }

    @GetMapping(path = {"/genero"})
    
    public ModelAndView genero(ModelAndView m){
        m.addObject("msn", "Este mensaje viene del controlador");
        m.setViewName("genero");
        return m;
    }

    @GetMapping(path = {"/disquera"})
    
    public ModelAndView disquera(ModelAndView m){
        m.addObject("msn", "Este mensaje viene del controlador");
        m.setViewName("disquera");
        return m;
    }
}