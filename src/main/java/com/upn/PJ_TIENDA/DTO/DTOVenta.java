/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upn.PJ_TIENDA.DTO;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author RYZEN7
 */

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
