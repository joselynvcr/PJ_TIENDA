
package com.upn.PJ_TIENDA.dao;

import com.upn.PJ_TIENDA.entidad.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface DaoProductos extends JpaRepository<Producto,Integer>{
    
    
//    @Modifying
//    @Transactional
//    @Query(value="INSERT INTO producto(pro_nombre,pro_precio,pro_imagen,pro_stock,pro_descripcion,pro_disponible,categoria_id,forma_id,marca_id)"
//                 + "VALUES(:#{user.})")
//    public int productosIns(@Param("user") Productos user);
//    
    
    
}
