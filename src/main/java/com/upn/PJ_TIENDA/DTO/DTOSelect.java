
package com.upn.PJ_TIENDA.DTO;


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
