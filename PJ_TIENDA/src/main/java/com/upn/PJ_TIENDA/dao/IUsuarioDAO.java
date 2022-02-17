
package com.upn.PJ_TIENDA.dao;

import com.upn.PJ_TIENDA.entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface IUsuarioDAO extends JpaRepository<Usuario,Integer>{
    
    public Usuario findByUsername(String Username);
    
    
    
//    @Modifying
//    @Transactional
//    @Query(value="INSERT INTO producto(pro_nombre,pro_precio,pro_imagen,pro_stock,pro_descripcion,pro_disponible,categoria_id,forma_id,marca_id)"
//                 + "VALUES(:#{user.})")
//    public int productosIns(@Param("user") Productos user);
//    
    
    
}
