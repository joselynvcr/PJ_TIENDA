package com.upn.PJ_TIENDA.controller;

import com.upn.PJ_TIENDA.entidad.Usuario;
import com.upn.PJ_TIENDA.services.UsuariosServiceImpl;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsuarioController {

    @Autowired
    UsuariosServiceImpl usuServ;

    //USUARIO
    @RequestMapping("/usuarios")
    public String usuariosSel(Model model) {
        model.addAttribute("lista", usuServ.usuarioSel());
        return "usuarios";
    }

    @RequestMapping("/nuevoUsuario")
    public String usuarioForm(Model model, Usuario usuario) {
        return "agregarUsuario"; //aqui
    }

    @PostMapping("/usuarioIns")
    public String usuarioIns(@Valid Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            return "agregarUsuario";
        }
        usuServ.usuarioIns(usuario);
        return "redirect:/usuarios";

    }

    @GetMapping("/actualizarUsuario")
    public String UsuarioFormUpd(Model model, Integer u_id) {
        System.out.println("id usuarioformUpd : " + u_id);
        model.addAttribute("usuario", usuServ.usuarioGet(u_id));
        return "actualizarUsuario";

    }

    @PostMapping("/usuarioUpd")
    public String usuarioUpd(@Valid Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            return "actualizarUsuario";
        }
        usuServ.usuarioUpd(usuario);
        return "redirect:/usuarios";
    }

    @RequestMapping("/usuarioDel")
    public String usuarioDel(Model model, Integer u_id) {
        usuServ.usuarioDel(u_id);
        return "redirect:/usuarios";
    }

    
    
    
}
