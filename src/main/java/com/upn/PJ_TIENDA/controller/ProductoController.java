
package com.upn.PJ_TIENDA.controller;

import com.upn.PJ_TIENDA.entidad.Producto;
import com.upn.PJ_TIENDA.services.CategoriasService;
import com.upn.PJ_TIENDA.services.FormasService;
import com.upn.PJ_TIENDA.services.MarcasService;
import com.upn.PJ_TIENDA.services.ProductosService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductoController {
    
//    @Autowired
//    ProductosRepository pr;    

    @Autowired
    ProductosService prodServ;
    
    @Autowired
    MarcasService marServ;

    @Autowired
    FormasService forServ;

    @Autowired
    CategoriasService catServ;
    
    //VAMOS A CREAR LA NAVEGACION     
    @RequestMapping("/productos")
    public String productoSel(Model model) {
        model.addAttribute("lista", prodServ.productoSel());
        return "productos";
    }

    @RequestMapping("/producto")
    public String productoGet(Model model, Integer pro_id) {
        model.addAttribute("dato", prodServ.productoGet(pro_id));
        return "detalleProducto";
    }

    //solo navegacion
    @RequestMapping("/nuevoProducto")
    public String productoForm(Model model, Producto producto) {
        model.addAttribute("marca", marServ.marcaSel());
        model.addAttribute("forma", forServ.formaSel());
        model.addAttribute("categoria", catServ.categoriaSel());
        return "agregarProducto";
    }
    
    @PostMapping("/productoIns")
    public String productoIns(@Valid Producto producto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("marca", marServ.marcaSel());
            model.addAttribute("forma", forServ.formaSel());
            model.addAttribute("categoria", catServ.categoriaSel());
            return "agregarProducto";
        }
        prodServ.productoIns(producto);
        return "redirect:/productos";
    }

    @RequestMapping("/actualizarProducto")
    public String productoFormUpd(Model model, Integer pro_id) {

        model.addAttribute("producto", prodServ.productoGet(pro_id));
        model.addAttribute("marca", marServ.marcaSel());
        model.addAttribute("forma", forServ.formaSel());
        model.addAttribute("categoria", catServ.categoriaSel());
        return "actualizarProducto";

    }

    @RequestMapping("/productoUpd")
    public String productoUpd(Model model, Producto p) {
        prodServ.productoUpd(p);
        return "redirect:/productos";
    }

    @RequestMapping("/productoDel")
    public String productoDel(Model model, Integer pro_id) {
        prodServ.productoDel(pro_id);
        return "redirect:/productos";
    }
    
}
