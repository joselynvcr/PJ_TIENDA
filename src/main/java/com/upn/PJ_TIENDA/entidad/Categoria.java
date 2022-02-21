package com.upn.PJ_TIENDA.entidad;

import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_id")
    private Integer c_id;

    @NotBlank(message = "Ingrese la Categoria, sino como sabemos..?")
    @Column(name = "c_nombre")
    private String c_nombre;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "categoria_id")
    private Set<Producto> producto;

    
    public Categoria(String c_nombre) {
        this.c_nombre = c_nombre;
    }

    
    
    public Categoria() {

    }

    public Categoria(Integer c_id, String c_nombre) {
        this.c_id = c_id;
        this.c_nombre = c_nombre;
    }

    
    
    
    public Categoria(Integer c_id) {
        this.c_id = c_id;
    }

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

      public String getC_nombre() {
        return c_nombre;
    }

    public void setC_nombre(String c_nombre) {
        this.c_nombre = c_nombre;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.c_id);
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
        final Categoria other = (Categoria) obj;
        if (!Objects.equals(this.c_id, other.c_id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return c_nombre;
    }

    public Set<Producto> getProductos() {
        return producto;
    }

    public void SetProductos(Set<Producto> productos) {
        this.producto = productos;
    }

   
}
