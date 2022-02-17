package com.upn.PJ_TIENDA.services;

import com.upn.PJ_TIENDA.dao.DaoForma;
import com.upn.PJ_TIENDA.entidad.Forma;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormasService {

    @Autowired
    DaoForma dao;

    public List<Forma> formaSel() {
        return dao.findAll();
    }

    public Forma formaGet(Integer id) {
        return dao.getById(id);
    }

    public void formaIns(Forma f) {
        System.out.println(f.getF_id());
        System.out.println(f.getF_nombre());
        System.out.println(f.getF_descripcion());
        
        dao.save(f);
    }

    public void formaUpd(Forma f) {
        dao.save(f);
    }

    public void formaDel(Integer id) {
        dao.deleteById(id);
    }

}
