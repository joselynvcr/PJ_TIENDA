
package com.upn.PJ_TIENDA.services;

import com.upn.PJ_TIENDA.entidad.Usuario;
import java.util.List;

public interface IUsuarioService {
    
    public Usuario findByUsername(String Username);
    public Usuario registrar(Usuario u);
    
     public List<Usuario> usuarioSel() ;

    public Usuario usuarioGet(Integer id) ;

    public void usuarioIns(Usuario u) ;

    public void usuarioUpd(Usuario u) ;

    public void usuarioDel(Integer u_id) ;
}