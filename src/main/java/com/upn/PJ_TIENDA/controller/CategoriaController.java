
package com.upn.PJ_TIENDA.controller;

import com.upn.PJ_TIENDA.entidad.Categoria;
import com.upn.PJ_TIENDA.services.CategoriasService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoriaController {

//    @Autowired
//    ProductosRepository pr;
    
    @Autowired
    CategoriasService catServ;
    
    //CATEGORIA
    @RequestMapping("/categorias")
    public String categoriasSel(Model model) {
        model.addAttribute("lista", catServ.categoriaSel());
        return "categorias";
    }

    @RequestMapping("/nuevaCategoria")
    public String CategoriaForm(Model model, Categoria categoria) {
        return "agregarCategoria"; //aqui
    }
    
    @PostMapping("/categoriaIns")
    public String categoriaIns(@Valid Categoria categoria, BindingResult result) {
        if (result.hasErrors()) {
            return "agregarCategoria";
        }
        catServ.categoriaIns(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/actualizarCategoria")
    public String CategoriaFormUpd(Model model, Integer id) {
        model.addAttribute("categoria", catServ.categoriaGet(id));
        return "actualizarCategoria";
    }

    @PostMapping("/categoriaUpd")
    public String categoriaUpd(Model model, Categoria c) {
        catServ.categoriaUpd(c);
        return "redirect:/categorias";
    }

    @RequestMapping("/categoriaDel")
    public String categoriaDel(Model model, Integer id) {
        System.out.println("id producto controller : " + id);
        //model.addAttribute("producto", prodServ.productoGet(id));
       catServ.categoriaDel(id);
        return "redirect:/categorias";
    }
}
