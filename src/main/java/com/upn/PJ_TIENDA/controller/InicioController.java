
package com.upn.PJ_TIENDA.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {
    
    @GetMapping("/")
    public String inicio(){
        return "index";
    }
    
}

