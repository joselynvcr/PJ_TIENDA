package com.upn.PJ_TIENDA.services;

import com.upn.PJ_TIENDA.dao.IVentaDAO;
import com.upn.PJ_TIENDA.entidad.Venta;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaServiceImpl implements IVentaService {

    @Autowired
    private IVentaDAO ventaDao;

    @Override
    public List<Venta> ventaSel() {
        return ventaDao.findAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Venta ventaGet(Integer id) {
        return ventaDao.getById(id);//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ventaIns(Venta v) {
        
//        LocalDateTime ldt = LocalDateTime.now();
//        v.setV_fecha(Timestamp.valueOf(ldt));//la fecha se captura al instante
//        v.setV_estadoventa(0);//siempre se crea una venta sin pagar   
         System.out.println(v.toString());
         
        ventaDao.save(v);
    }

    @Override
    public void ventaUpd(Venta v) {
        ventaDao.save(v); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ventaDel(Integer u_id) {
        ventaDao.deleteById(u_id);           //To change body of generated methods, choose Tools | Templates.
    }

}
