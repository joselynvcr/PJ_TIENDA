
package com.upn.PJ_TIENDA.dao;

import com.upn.PJ_TIENDA.entidad.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DaoCategorias extends JpaRepository<Categoria, Integer> {
    
}
