
package com.upn.PJ_TIENDA.services;

import com.upn.PJ_TIENDA.entidad.Venta;
import java.util.List;

public interface IVentaService {
    
   // public Venta findByUsername(String Username);
    
   // public Venta registrar(Venta u);
    
     public List<Venta> ventaSel() ;

    public Venta ventaGet(Integer id) ;

    public void ventaIns(Venta u) ;

    public void ventaUpd(Venta u) ;

    public void ventaDel(Integer u_id) ;
}