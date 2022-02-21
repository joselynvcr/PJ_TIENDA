/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upn.PJ_TIENDA.dao;

import com.upn.PJ_TIENDA.entidad.DetalleVenta;
import com.upn.PJ_TIENDA.entidad.Producto;
import com.upn.PJ_TIENDA.entidad.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author RYZEN7
 */

public interface DaoDetalleVenta extends JpaRepository<DetalleVenta, Integer> {
    
  //@Query("SELECT u FROM DetalleVenta u WHERE u.dt_venta_id = ?1")
  //@Query("SELECT DISTINCT p FROM Producto p JOIN p.detalleVentaCollection c WHERE c.dt_venta_id=:ventaId")
  @Query("SELECT p FROM Producto p JOIN p.ventas v WHERE v.v_id=:ventaId")
  public List<Producto> findByDt_venta_id(@Param("ventaId") int ventaId);

}
