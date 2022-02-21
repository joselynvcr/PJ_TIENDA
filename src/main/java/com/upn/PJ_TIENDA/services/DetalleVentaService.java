/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upn.PJ_TIENDA.services;

import com.upn.PJ_TIENDA.dao.DaoDetalleVenta;
import com.upn.PJ_TIENDA.entidad.Producto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DetalleVentaService  { 
    
    @Autowired
    private DaoDetalleVenta objDetalleVenta;
    
    public List<Producto> listaProductosPorVenta(int ventaId) {
        
        return objDetalleVenta.findByDt_venta_id(ventaId); //To change body of generated methods, choose Tools | Templates.
    }

}
