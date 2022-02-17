
package com.upn.PJ_TIENDA.dao;

import com.upn.PJ_TIENDA.entidad.Categoria;
import com.upn.PJ_TIENDA.entidad.Forma;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DaoForma extends JpaRepository<Forma, Integer> {
    
}
