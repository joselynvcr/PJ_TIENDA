package com.upn.PJ_TIENDA.entidad;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "venta")
public class Venta implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "v_id")
    private Integer v_id;

    @NotNull
    @Column(name = "v_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date v_fecha;

    @NotNull
    @Column(name = "v_estadoventa")
    private Integer v_estadoventa;

//     //  @JoinColumn(name = "v_usuario_id", referencedColumnName = "u_id")
//    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
//    @JoinColumn(name = "v_usuario_id")
//    private int vusuario_id;
    
    
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})    
    @JoinColumn(name = "v_usuario_id", referencedColumnName = "u_id")
    private Usuario v_usuario_id;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venta")
    private Collection<DetalleVenta> detalleVentaCollection;

    
    public Venta() {
    }

    public Venta(Integer v_id) {
        this.v_id = v_id;
    }

    public Venta(Integer v_id, Date v_fecha, Integer v_estadoventa, Usuario v_usuario_id) {
        this.v_id = v_id;
        this.v_fecha = v_fecha;
        this.v_estadoventa = v_estadoventa;
        this.v_usuario_id = v_usuario_id;
    }

    public Venta(Date v_fecha, Integer v_estadoventa, Usuario v_usuario_id) {
        this.v_fecha = v_fecha;
        this.v_estadoventa = v_estadoventa;
        this.v_usuario_id = v_usuario_id;
    }

//    public Venta(Date v_fecha, Integer v_estadoventa, int vusuario_id) {
//      
//        this.v_fecha = v_fecha;
//        this.v_estadoventa = v_estadoventa;
//        this.vusuario_id = vusuario_id;
//    }
//    
    

    public Integer getV_id() {
        return v_id;
    }

    public void setV_id(Integer v_id) {
        this.v_id = v_id;
    }

    public Date getV_fecha() {
        return v_fecha;
    }

    public void setV_fecha(Date v_fecha) {
        this.v_fecha = v_fecha;
    }

    public Integer getV_estadoventa() {
        return v_estadoventa;
    }

    public void setV_estadoventa(Integer v_estadoventa) {
        this.v_estadoventa = v_estadoventa;
    }

    public Usuario getV_usuario_id() {
        return v_usuario_id;
    }

    public void setV_usuario_id(Usuario v_usuario_id) {
        this.v_usuario_id = v_usuario_id;
    }

//    public void setV_usuario_id(int vusuario_id) {
//        this.vusuario_id=vusuario_id;
//    }


    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.v_id);
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
        final Venta other = (Venta) obj;
        if (!Objects.equals(this.v_id, other.v_id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Venta{" + "v_id=" + v_id + ", v_fecha=" + v_fecha + ", v_estadoventa=" + v_estadoventa + ", v_usuario_id=" + v_usuario_id + '}';
    }

//    @XmlTransient
//    public Collection<DetalleVenta> getDetalleVentaCollection() {
//        return detalleVentaCollection;
//    }
//
//    public void setDetalleVentaCollection(Collection<DetalleVenta> detalleVentaCollection) {
//        this.detalleVentaCollection = detalleVentaCollection;
//    }

   
}
