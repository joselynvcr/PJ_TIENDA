/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upn.PJ_TIENDA.DTO;

/**
 *
 * @author RYZEN7
 */
public class DTOSelect {
    private String Text;
    private String Value;

    public String getText() {
        return Text;
    }

    public void setText(String Text) {
        this.Text = Text;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String Value) {
        this.Value = Value;
    }

    public DTOSelect(String Value,String Text) {
        this.Text = Text;
        this.Value = Value;
    }
    
}
