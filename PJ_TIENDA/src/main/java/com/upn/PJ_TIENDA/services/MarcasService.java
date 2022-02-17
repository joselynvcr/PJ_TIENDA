package com.upn.PJ_TIENDA.services;

import com.upn.PJ_TIENDA.dao.DaoMarcas;
import com.upn.PJ_TIENDA.entidad.Marca;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarcasService {

    @Autowired
    DaoMarcas dao;

    public List<Marca> marcaSel() {
        return dao.findAll();
    }

    public Marca marcaGet(Integer id) {
        return dao.getById(id);
    }

    public void marcaIns(Marca m) {
        System.out.println(m.getM_id());
        System.out.println(m.getM_nombre());
        dao.save(m);
    }

    public void marcaUpd(Marca m) {
        dao.save(m);
    }

    public void marcaDel(Integer id) {
        dao.deleteById(id);
    }

}
