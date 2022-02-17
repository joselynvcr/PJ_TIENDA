package com.upn.PJ_TIENDA.controller;

import com.upn.PJ_TIENDA.entidad.Marca;
import com.upn.PJ_TIENDA.services.MarcasService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MarcaController {

//    @Autowired
//    ProductosRepository pr;
//    
    @Autowired
    MarcasService marServ;

    //MARCA
    @RequestMapping("/marcas")
    public String marcasSel(Model model) {
        model.addAttribute("lista", marServ.marcaSel());
        return "marcas";
    }

    @RequestMapping("/nuevaMarca")
    public String marcaForm(Model model, Marca marca) {
        //model.addAttribute("marca", marca);
        return "agregarMarca";
    }

    @PostMapping("/marcaIns")
    public String marcaIns(@Valid Marca marca, BindingResult result) {
        if (result.hasErrors()) {
            return "agregarMarca";
        }

        marServ.marcaIns(marca);
        return "redirect:/marcas";
    }

    @RequestMapping("/actualizarMarca")
    public String MarcaFormUpd(Model model, Integer id) {
        model.addAttribute("marca", marServ.marcaGet(id));
        return "actualizarMarca";
    }

    @RequestMapping("/marcaUpd")
    public String marcaUpd(Model model, Marca m) {
        marServ.marcaUpd(m);
        return "redirect:/marcas";
    }

    @RequestMapping("/marcaDel")
    public String marcaDel(Model model, Integer id) {
        System.out.println("id producto controller : " + id);
        //model.addAttribute("producto", prodServ.productoGet(id));
        marServ.marcaDel(id);
        return "redirect:/marcas";
    }
}
