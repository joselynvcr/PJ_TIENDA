package com.upn.PJ_TIENDA.entidad;

import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "forma")
public class Forma {

    
    @Id   
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Column(name = "f_id")
    private Integer f_id;
  
    @NotBlank(message = "Ingrese la Forma, sino como sabemos..?")
    @Column(name = "f_nombre")
    private String f_nombre;
 
    @NotBlank(message = "Ingrese la Descripcion, sino como sabemos..?")
    @Column(name = "f_descripcion")
    private String f_descripcion;
    
    public Forma() {
    }

    public Forma(String f_nombre, String f_descripcion) {
        this.f_nombre = f_nombre;
        this.f_descripcion = f_descripcion;
    }
    
    

    public Forma(Integer f_id) {
        this.f_id = f_id;
    }

    public Integer getF_id() {
        return f_id;
    }

    public void setF_id(Integer f_id) {
        this.f_id = f_id;
    }

    public String getF_nombre() {
        return f_nombre;
    }

    public void setF_nombre(String f_nombre) {
        this.f_nombre = f_nombre;
    }

    public String getF_descripcion() {
        return f_descripcion;
    }

    public void setF_descripcion(String f_descripcion) {
        this.f_descripcion = f_descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.f_id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Forma other = (Forma) obj;
        if (!Objects.equals(this.f_id, other.f_id)) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return f_nombre;
    }

    
    
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy="forma_id")
    private Set<Producto> producto;

    public Set<Producto> getProductos(){
        return producto;
    }
    public void SetProductos(Set<Producto> productos){
        this.producto = productos;
    }
    
    
}
