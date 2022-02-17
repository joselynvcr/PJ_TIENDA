package com.upn.PJ_TIENDA.services;

import com.upn.PJ_TIENDA.entidad.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.upn.PJ_TIENDA.dao.IUsuarioDAO;
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
        u.setU_password(passwordEncoder.encode(u.getU_password()));
        return usuarioDao.save(u);
    }          
   

    @Override
    public List<Usuario> usuarioSel() {
        return usuarioDao.findAll();
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
