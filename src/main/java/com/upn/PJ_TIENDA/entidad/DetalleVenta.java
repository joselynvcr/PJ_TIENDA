package com.upn.PJ_TIENDA.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Josy
 */
@Entity
@Table(name = "detalle_venta")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "DetalleVenta.findAll", query = "SELECT d FROM DetalleVenta d"),
//    @NamedQuery(name = "DetalleVenta.findByDtProductoId", query = "SELECT d FROM DetalleVenta d WHERE d.detalleVentaPK.dtProductoId = :dtProductoId"),
//    @NamedQuery(name = "DetalleVenta.findByDtVentaId", query = "SELECT d FROM DetalleVenta d WHERE d.detalleVentaPK.dtVentaId = :dtVentaId"),
//    @NamedQuery(name = "DetalleVenta.findByDtCantidad", query = "SELECT d FROM DetalleVenta d WHERE d.dtCantidad = :dtCantidad"),
//    @NamedQuery(name = "DetalleVenta.findByDtPrecio", query = "SELECT d FROM DetalleVenta d WHERE d.dtPrecio = :dtPrecio"),
//    @NamedQuery(name = "DetalleVenta.findByDtDescuento", query = "SELECT d FROM DetalleVenta d WHERE d.dtDescuento = :dtDescuento"),
//    @NamedQuery(name = "DetalleVenta.findByDtTotal", query = "SELECT d FROM DetalleVenta d WHERE d.dtTotal = :dtTotal")})
public class DetalleVenta implements Serializable{
 private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dt_id")
    private Integer dt_id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dt_cantidad")
    private int dt_cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "dt_precio")
    private BigDecimal dt_precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dt_total")
    private BigDecimal dt_total;
    @JoinColumn(name = "dt_producto_id", referencedColumnName = "pro_id")
    @ManyToOne(optional = false)
    private Producto dt_producto_id;
    @JoinColumn(name = "dt_venta_id", referencedColumnName = "v_id")
    @ManyToOne(optional = false)
    private Venta dt_venta_id;

    public DetalleVenta() {
    }

    public DetalleVenta(Integer dt_id) {
        this.dt_id = dt_id;
    }

    public DetalleVenta(Integer dt_id, int dt_cantidad, BigDecimal dt_precio, BigDecimal dt_total) {
        this.dt_id = dt_id;
        this.dt_cantidad = dt_cantidad;
        this.dt_precio = dt_precio;
        this.dt_total = dt_total;
    }

    public Integer getDtId() {
        return dt_id;
    }

    public void setDtId(Integer dt_id) {
        this.dt_id = dt_id;
    }

    public int getDtCantidad() {
        return dt_cantidad;
    }

    public void setDtCantidad(int dt_cantidad) {
        this.dt_cantidad = dt_cantidad;
    }

    public BigDecimal getDtPrecio() {
        return dt_precio;
    }

    public void setDtPrecio(BigDecimal dt_precio) {
        this.dt_precio = dt_precio;
    }

    public BigDecimal getDtTotal() {
        return dt_total;
    }

    public void setDtTotal(BigDecimal dt_total) {
        this.dt_total = dt_total;
    }

    public Producto getDtProductoId() {
        return dt_producto_id;
    }

    public void setDtProductoId(Producto dt_producto_id) {
        this.dt_producto_id = dt_producto_id;
    }

    public Venta getDtVentaId() {
        return dt_venta_id;
    }

    public void setDtVentaId(Venta dt_venta_id) {
        this.dt_venta_id = dt_venta_id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dt_id != null ? dt_id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleVenta)) {
            return false;
        }
        DetalleVenta other = (DetalleVenta) object;
        if ((this.dt_id == null && other.dt_id != null) || (this.dt_id != null && !this.dt_id.equals(other.dt_id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.upn.PJ_TIENDA.entidad.DetalleVenta[ dt_id=" + dt_id + " ]";
    }
}
