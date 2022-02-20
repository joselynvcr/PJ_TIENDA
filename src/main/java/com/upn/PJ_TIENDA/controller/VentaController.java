package com.upn.PJ_TIENDA.controller;

import com.upn.PJ_TIENDA.entidad.Venta;
import com.upn.PJ_TIENDA.services.UsuariosServiceImpl;
import com.upn.PJ_TIENDA.services.VentaServiceImpl;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VentaController {

    @Autowired
    VentaServiceImpl ventaServ;

    @Autowired
    UsuariosServiceImpl usuServ;

    //VAMOS A CREAR LA NAVEGACION     
    @RequestMapping("/ventas")
    public String ventaSel(Model model) {
        model.addAttribute("lista", ventaServ.ventaSel());
        return "ventas";
    }

    @RequestMapping("/nuevaVenta")
    public String ventaForm(Model model, Venta venta) {
        
        System.out.println("nuevaVenta");

//        LocalDateTime ldt = LocalDateTime.now();       
//        venta.setV_fecha(Timestamp.valueOf(ldt));//la fecha se captura al instante
//        venta.setV_estadoventa(0);//siempre se crea una venta sin pagar 
        model.addAttribute("usuario", usuServ.usuariosCliente());

        
        System.out.println(venta.toString());

        return "agregarVenta"; //aqui
    }

    @PostMapping("/ventaIns")
    public String ventaIns(@Valid Venta venta, BindingResult result, Model model) {

        System.out.println("agregarVenta");
        
        model.addAttribute("usuario", usuServ.usuariosCliente());
        
       // LocalDateTime ldt = LocalDateTime.now();
//        venta.setV_fecha(new Date());//la fecha se captura al instante
//        venta.setV_estadoventa(0);//siempre se crea una venta sin pagar      

        
        if (result.hasErrors()) {
            System.out.println(venta.toString());
           
            return "agregarVenta";
        }

        ventaServ.ventaIns(venta);
        
        return "redirect:/ventas";

        
    }

    
    
}
