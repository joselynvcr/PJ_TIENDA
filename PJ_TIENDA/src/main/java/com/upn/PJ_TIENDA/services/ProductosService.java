package com.upn.PJ_TIENDA.services;

import com.upn.PJ_TIENDA.dao.DaoProductos;
import com.upn.PJ_TIENDA.entidad.Producto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductosService {

    @Autowired
    DaoProductos dao;

    public List<Producto> productoSel() {
        return dao.findAll();
    }

    public Producto productoGet(Integer id){
        return dao.getById(id);
    }

    public void productoIns(Producto p) {
        dao.save(p);
    }

    public void productoUpd(Producto p) {

        dao.save(p);
    }

    public void productoDel(Integer pro_id) { 
            dao.deleteById(pro_id);             
    }

}
