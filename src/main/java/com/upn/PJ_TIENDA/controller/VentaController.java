package com.upn.PJ_TIENDA.controller;

import com.upn.PJ_TIENDA.DTO.DTOSelect;
import com.upn.PJ_TIENDA.DTO.DTOVenta;
import com.upn.PJ_TIENDA.entidad.Usuario;
import com.upn.PJ_TIENDA.entidad.Venta;
import com.upn.PJ_TIENDA.services.UsuariosServiceImpl;
import com.upn.PJ_TIENDA.services.VentaServiceImpl;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
        System.out.println(ventaServ.ventaSel());
        model.addAttribute("lista", ventaServ.ventaSel());
        return "ventas";
    }

    @RequestMapping("/nuevaVenta")
    public String ventaForm(Model model) {           
        List<Usuario> lstUsuarios= usuServ.usuariosCliente();
        List<DTOSelect> lstUsuariosSelect= new ArrayList<DTOSelect>();
         for (Usuario objUser : lstUsuarios) { 
             lstUsuariosSelect.add(new DTOSelect(objUser.getU_id().toString(),objUser.getU_nombres()));
        }
      
        model.addAttribute("usuarios", lstUsuariosSelect);
        //System.out.println(venta.toString());
        return "agregarVenta"; //aqui
    }

    @PostMapping("/ventaIns")
    public String ventaIns(@Valid DTOVenta ventaDTO,BindingResult result) {

        if (result.hasErrors()) {
            System.out.println(result);
            return "agregarVenta";
        }        
        System.out.println("insertar.................");          
        Venta objVenta=new Venta();
        objVenta.setV_fecha(new Date(System.currentTimeMillis()));
        objVenta.setV_estadoventa(0);   
        objVenta.setV_usuario_id(usuServ.usuarioGet(Integer.parseInt(ventaDTO.getUsuarioSel())));
        
        ventaServ.ventaIns(objVenta);
        System.out.println("RESULTADO");
        System.out.println(result);
        
        return "redirect:/ventas";
    }


    
    
}
