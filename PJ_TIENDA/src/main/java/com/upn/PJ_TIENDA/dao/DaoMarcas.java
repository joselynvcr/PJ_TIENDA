
package com.upn.PJ_TIENDA.dao;


import com.upn.PJ_TIENDA.entidad.Marca;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DaoMarcas extends JpaRepository<Marca, Integer> {
    
}
