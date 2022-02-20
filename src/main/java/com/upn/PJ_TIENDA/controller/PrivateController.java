package com.upn.PJ_TIENDA.controller;

import com.upn.PJ_TIENDA.entidad.Usuario;
import com.upn.PJ_TIENDA.services.IUsuarioService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/private")
public class PrivateController {

    //métodos que requieran autenticación
    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/index")
    public String index(Authentication auth, HttpSession session) {

        String username = auth.getName();
        System.out.println(username);
         String rol="";
        Usuario usuario = usuarioService.findByUsername(username);
        rol=usuario.getU_perfil();
       
        if (session.getAttribute("usuario") == null) {
            usuario = usuarioService.findByUsername(username);
            usuario.setPassword(null);
            rol=usuario.getU_perfil();
            System.out.println("rol : " +rol);
            session.setAttribute("usuario", usuario);
        }
        if("admin".equals(rol)){  
             System.out.println("rol : " +rol);
            return "inicioAdmin";
        }else{
              System.out.println("rol : " +rol);
            System.out.println("else : " +"index");
            return"inicioUser";
        }     
        
    }
    
//    @GetMapping("/login?logout")
//     public String nav(Authentication auth, HttpSession session) {
//         String username = auth.getName();
//         System.out.println(username);
//        String rol="";
//        if (session.getAttribute("usuario") == null) {
//            Usuario usuario = usuarioService.findByUsername(username);
//            usuario.setPassword(null);
//            rol=usuario.getU_perfil();
//            System.out.println("rol : " +rol);
//            session.setAttribute("usuario", usuario);
//        }
//        if("admin".equals(rol)){  
//             System.out.println("rol : " +rol);
//            return "inicioAdmin";
//        }else{
//              System.out.println("rol : " +rol);
//            System.out.println("else : " +"index");
//            return"index";
//        }     
//     }
    
    
    
    

     @GetMapping("/iniAdmin")
     public String iniAdmin(Model model) {
          return "inicioAdmin";
     }
      @GetMapping("/iniUser")
     public String iniUser(Model model) {
          return "inicioUser";
     }
     
    
    
}
