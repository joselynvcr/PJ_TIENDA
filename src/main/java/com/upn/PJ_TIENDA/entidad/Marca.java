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
@Table(name = "marca")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "m_id")
    private Integer m_id;

    @NotBlank(message = "Ingrese la Marca, sino como sabemos ..?")  
    @Column(name = "m_nombre")
    private String m_nombre;   


    public Marca() {
    }

    public Marca(String m_nombre) {
        this.m_nombre = m_nombre;
    }

    public Marca(Integer m_id, String m_nombre) {
        this.m_id = m_id;
        this.m_nombre = m_nombre;
    }
    
    public Marca(Integer m_id) {
        this.m_id = m_id;
    }

    public Integer getM_id() {
        return m_id;
    }

    public void setM_id(Integer m_id) {
        this.m_id = m_id;
    }

    public String getM_nombre() {
        return m_nombre;
    }

    public void setM_nombre(String m_nombre) {
        this.m_nombre = m_nombre;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.m_id);
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
        final Marca other = (Marca) obj;
        if (!Objects.equals(this.m_id, other.m_id)) {
            return false;
        }
        return true;
    }
    
    
    
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "marca_id")
    private Set<Producto> producto;

    public Set<Producto> getProductos() {
        return producto;
    }

    public void SetProductos(Set<Producto> productos) {
        this.producto = productos;
    }

}
