/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upn.PJ_TIENDA.controller;

import com.upn.PJ_TIENDA.entidad.DetalleVenta;
import com.upn.PJ_TIENDA.services.DetalleVentaService;
import com.upn.PJ_TIENDA.services.UsuariosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DetalleVentaController {

    @Autowired
    DetalleVentaService detalleVentaServ;

    @Autowired
    UsuariosServiceImpl usuServ;

    //VAMOS A CREAR LA NAVEGACION     
    @RequestMapping("/productosByVenta")
    public String ventaSel(Model model, int ventaId) {   
        System.out.println("productosByVenta");
        model.addAttribute("lstaProductos", detalleVentaServ.listaProductosPorVenta(ventaId));
        return "productosPorVenta";
    }

    
}
