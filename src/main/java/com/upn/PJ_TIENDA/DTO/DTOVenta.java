
package com.upn.PJ_TIENDA.DTO;

import javax.validation.constraints.NotBlank;



public class DTOVenta {
    
    @NotBlank(message="Es obligatorio")
    private String usuarioSel;

    public String getUsuarioSel() {
        return usuarioSel;
    }

    public void setUsuarioSel(String usuarioSel) {
        this.usuarioSel = usuarioSel;
    }

    public DTOVenta(String usuarioSel) {
        this.usuarioSel = usuarioSel;
    }

   
   

}
