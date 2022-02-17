package com.upn.PJ_TIENDA.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controlador {

//    @Autowired
//    ProductosRepository pr;
    
    
//    @RequestMapping("/inicio")
//    public String inicio(Model model) {
//        return "index";
//    }
    
    @RequestMapping("/administrador")
    public String administrador(Model model) {
        return "admin";
    }

    

//    @RequestMapping("/logearse")
//    public String login(Model model) {
//        return "login";
//    }


    
}
