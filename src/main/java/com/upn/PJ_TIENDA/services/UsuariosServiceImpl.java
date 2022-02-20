package com.upn.PJ_TIENDA.services;

import com.upn.PJ_TIENDA.entidad.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.upn.PJ_TIENDA.dao.IUsuarioDAO;
import java.util.ArrayList;
import java.util.function.Consumer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UsuariosServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioDAO usuarioDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Usuario findByUsername(String username) {
        return usuarioDao.findByUsername(username);

    }

    @Override
    public Usuario registrar(Usuario u) {
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        return usuarioDao.save(u);
    }

    @Override
    public List<Usuario> usuarioSel() {
        return usuarioDao.findAll();
    }

    @Override
    public List<Usuario> usuariosCliente() {
        
        System.out.println("usuariosCliente");
        
        List<Usuario> result = usuarioDao.findAll();
        List<Usuario> Finalresult = new ArrayList<>();

        for(int i=0; i<result.size(); i++){
            if ("cliente".equals(result.get(i).getU_perfil())) {
                Finalresult.add(result.get(i));
                //System.out.println(songs);                
            }
        }
        return Finalresult;
        
    }

    @Override
    public Usuario usuarioGet(Integer id) {
        return usuarioDao.getById(id);
    }

    @Override
    public void usuarioIns(Usuario u) {
        usuarioDao.save(u);
    }

    @Override
    public void usuarioUpd(Usuario u) {
        System.out.println("id upd : " + u.getU_id());
        usuarioDao.save(u);
    }

    @Override
    public void usuarioDel(Integer u_id) {
        System.out.println("id del : " + u_id);
        usuarioDao.deleteById(u_id);
    }

}
