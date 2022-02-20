package com.upn.PJ_TIENDA.controller;

import com.upn.PJ_TIENDA.entidad.Usuario;
import com.upn.PJ_TIENDA.services.IUsuarioService;
import com.upn.PJ_TIENDA.services.VentaServiceImpl;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    VentaServiceImpl ventaServ;

    @GetMapping("/login")
    public String login(Model model) {

//         LocalDateTime ldt = LocalDateTime.now();
//         
//        Venta venta = new Venta(Timestamp.valueOf(ldt),0, new Usuario(19));
//
//       
////        venta.setV_fecha(Timestamp.valueOf(ldt));//la fecha se captura al instante
////        venta.setV_estadoventa(0);//siempre se crea una venta sin pagar 
////        venta.setV_usuario_id(19);
//
//        ventaServ.ventaIns(venta);
//        System.out.println("agrego satisfactoriamente");
        
        model.addAttribute("usuario", new Usuario());
        return "login";

    }

    @GetMapping("/registro")
    public String registroForm(Model model, Usuario usuario) {
        usuario.setU_perfil("cliente");
        model.addAttribute("usuario", usuario);
        return "registro";
    }

    //permite guardar en BD
//    @PostMapping("/auth/registro")
//    public String registro(@Valid @ModelAttribute Usuario usuario, BindingResult result, Model model) {
//        usuario.setU_perfil("cliente");
//        if (result.hasErrors()) {
//            System.out.println(result.toString());
//            System.out.println(usuario.toString());
//            System.out.println("ERROR");
//            return "redirect:/auth/registro";
//        } else {
//            System.out.println("REGISTRADO EXITOSAMENTE");
//            model.addAttribute("usuario", usuarioService.registrar(usuario));
//        }
//
//        return "redirect:/auth/login";
//    }
    @PostMapping("/registro")
    public String registro(@Valid Usuario usuario, BindingResult result) {
        usuario.setU_perfil("cliente");
        if (result.hasErrors()) {
            System.out.println(result.toString());
            System.out.println(usuario.toString());
            System.out.println("ERROR");
            return "registro";
        }

        usuarioService.registrar(usuario);
        return "redirect:/login";
    }

    private void setDummyCookie(HttpServletResponse response) {
        //Cookie cookie = new Cookie(name: "dummyCookie", value: "dummy_cookie");
        Cookie cookie = new Cookie("dummyCookie", "dummy_cookie");
        cookie.setMaxAge(2592000);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

}
