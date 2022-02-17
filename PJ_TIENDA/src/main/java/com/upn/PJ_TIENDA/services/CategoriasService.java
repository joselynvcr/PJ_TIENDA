package com.upn.PJ_TIENDA.services;

import com.upn.PJ_TIENDA.dao.DaoCategorias;
import com.upn.PJ_TIENDA.entidad.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriasService {

    @Autowired
    DaoCategorias dao;

    public List<Categoria> categoriaSel() {
        return dao.findAll();
    }

    public Categoria categoriaGet(Integer id) {
        return dao.getById(id);
    }

    public void categoriaIns(Categoria p) {
        dao.save(p);
    }

    public void categoriaUpd(Categoria p) {
        dao.save(p);
    }

    public void categoriaDel(Integer id) {
        dao.deleteById(id);
    }

}
