package com.upn.PJ_TIENDA.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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

//    private static final long serialVersionUID = 1L;
//    @EmbeddedId
//    protected DetalleVentaPK detalleVentaPK;
    
    @Id
    @NotNull
    @Column(name = "dt_producto_id")
    private int dt_producto_id;
    
    @Id
    @NotNull
    @Column(name = "dt_venta_id")
    private int dt_venta_id;
    
    @NotNull
    @Column(name = "dt_cantidad")
    private int dt_cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    @NotNull
    @Column(name = "dt_precio")
    private BigDecimal dt_precio;
   
    @NotNull
    @Column(name = "dt_total")
    private BigDecimal dt_total;

    @JoinColumn(name = "dt_producto_id", referencedColumnName = "pro_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;

    @JoinColumn(name = "dt_venta_id", referencedColumnName = "v_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Venta venta;

    public DetalleVenta() {
    }

    public DetalleVenta(int dt_producto_id, int dt_venta_id, int dt_cantidad, BigDecimal dt_precio, BigDecimal dt_total, Producto producto, Venta venta) {
        this.dt_producto_id = dt_producto_id;
        this.dt_venta_id = dt_venta_id;
        this.dt_cantidad = dt_cantidad;
        this.dt_precio = dt_precio;
        this.dt_total = dt_total;
        this.producto = producto;
        this.venta = venta;
    }

    public DetalleVenta(int dt_producto_id) {
        this.dt_producto_id = dt_producto_id;
    }

    public int getDt_producto_id() {
        return dt_producto_id;
    }

    public void setDt_producto_id(int dt_producto_id) {
        this.dt_producto_id = dt_producto_id;
    }

    public int getDt_venta_id() {
        return dt_venta_id;
    }

    public void setDt_venta_id(int dt_venta_id) {
        this.dt_venta_id = dt_venta_id;
    }

    public int getDt_cantidad() {
        return dt_cantidad;
    }

    public void setDt_cantidad(int dt_cantidad) {
        this.dt_cantidad = dt_cantidad;
    }

    public BigDecimal getDt_precio() {
        return dt_precio;
    }

    public void setDt_precio(BigDecimal dt_precio) {
        this.dt_precio = dt_precio;
    }

    public BigDecimal getDt_total() {
        return dt_total;
    }

    public void setDt_total(BigDecimal dt_total) {
        this.dt_total = dt_total;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + this.dt_producto_id;
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
        final DetalleVenta other = (DetalleVenta) obj;
        if (this.dt_producto_id != other.dt_producto_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" + "dt_producto_id=" + dt_producto_id + ", dt_venta_id=" + dt_venta_id + ", dt_cantidad=" + dt_cantidad + ", dt_precio=" + dt_precio + ", dt_total=" + dt_total + ", producto=" + producto + ", venta=" + venta + '}';
    }

   

    

  

    
}
