
package com.upn.PJ_TIENDA.controller;

import com.upn.PJ_TIENDA.entidad.Forma;
import com.upn.PJ_TIENDA.services.FormasService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormaController {
//
//    @Autowired
//    ProductosRepository pr;
//    
    @Autowired
    FormasService forServ;

    
    //FORMA
    @RequestMapping("/formas")
    public String formasSel(Model model) {
        model.addAttribute("lista", forServ.formaSel());
        return "formas";
    }

    @RequestMapping("/nuevaForma")
    public String FormaForm(Model model, Forma forma) {
        return "agregarForma"; //aqui
    }
    
    @PostMapping("/formaIns")
    public String formaIns(@Valid Forma forma, BindingResult result) {
        if (result.hasErrors()) {
            return "agregarForma";
        }
        forServ.formaIns(forma);
        return "redirect:/formas";
    }

    @RequestMapping("/actualizarForma")
    public String FormaFormUpd(Model model, Integer id) {
        model.addAttribute("forma", forServ.formaGet(id));
        return "actualizarForma";
    }

    @RequestMapping("/formaUpd")
    public String formaUpd(Model model, Forma f) {
        forServ.formaUpd(f);
        return "redirect:/formas";
    } 
    
    @RequestMapping("/formaDel")
    public String formaDel(Model model, Integer id) {
        System.out.println("id producto controller : " + id);
        //model.addAttribute("producto", prodServ.productoGet(id));
        forServ.formaDel(id);
        return "redirect:/formas";
    }
}
