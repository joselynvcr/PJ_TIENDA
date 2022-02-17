package com.upn.PJ_TIENDA.entidad;

import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pro_id;
    
    @NotBlank(message = "Ingrese el Nombre del Producto, sino como sabemos..?") 
    @Column(name = "pro_nombre")
    private String pro_nombre;
    
    @NotNull(message = "Ingrese el precio, sino como sabemos..?")  
    @Min(value = 0)
    @Column(name = "pro_precio")
    private BigDecimal pro_precio;
    
    @NotBlank(message = "Cargue la imagen, sino como la vemos..?")   
    @Column(name = "pro_imagen")
    private String pro_imagen;
    
    @NotNull(message = "Ingrese el stock, sino como sabemos..?")   
    @Column(name = "pro_stock")
    private Integer pro_stock;
    
    @NotBlank(message = "Ingrese la descripcion, sino como sabemos..?")  
    @Column(name = "pro_descripcion")
    private String pro_descripcion;
    
    @NotNull(message = "Ingrese la disponibilidad, sino como sabemos..?")   
    @Column(name = "pro_disponible")
    private Character pro_disponible;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @NotNull(message = "Ingrese la marca, sino como sabemos..?") 
    @JoinColumn(name = "marca_id")
    private Marca marca_id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @NotNull(message = "Ingrese la forma, sino como sabemos..?") 
    @JoinColumn(name = "forma_id")
    private Forma forma_id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @NotNull(message = "Ingrese la categoria, sino como sabemos..?") 
    @JoinColumn(name = "categoria_id")
    private Categoria categoria_id;

    public Producto() {

    }

    public Producto(String pro_nombre, BigDecimal pro_precio, String pro_imagen, int pro_stock, String pro_descripcion, Character pro_disponible, Marca marca_id, Forma forma_id, Categoria categoria_id) {

        this.pro_nombre = pro_nombre;
        this.pro_precio = pro_precio;
        this.pro_imagen = pro_imagen;
        this.pro_stock = pro_stock;
        this.pro_descripcion = pro_descripcion;
        this.pro_disponible = pro_disponible;
        this.marca_id = marca_id;
        this.forma_id = forma_id;
        this.categoria_id = categoria_id;
    }

    public Producto(Integer pro_id, String pro_nombre, BigDecimal pro_precio, String pro_imagen, int pro_stock, String pro_descripcion, Character pro_disponible, Marca marca_id, Forma forma_id, Categoria categoria_id) {
        this.pro_id = pro_id;
        this.pro_nombre = pro_nombre;
        this.pro_precio = pro_precio;
        this.pro_imagen = pro_imagen;
        this.pro_stock = pro_stock;
        this.pro_descripcion = pro_descripcion;
        this.pro_disponible = pro_disponible;
        this.marca_id = marca_id;
        this.forma_id = forma_id;
        this.categoria_id = categoria_id;
    }



    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.pro_id);
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
        final Producto other = (Producto) obj;
        if (!Objects.equals(this.pro_id, other.pro_id)) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return  pro_id.toString();
//    }

    public Integer getPro_id() {
        return pro_id;
    }

    public void setPro_id(Integer pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_nombre() {
        return pro_nombre;
    }

    public void setPro_nombre(String pro_nombre) {
        this.pro_nombre = pro_nombre;
    }

    public BigDecimal getPro_precio() {
        return pro_precio;
    }

    public void setPro_precio(BigDecimal pro_precio) {
        this.pro_precio = pro_precio;
    }

    public String getPro_imagen() {
        return pro_imagen;
    }

    public void setPro_imagen(String pro_imagen) {
        this.pro_imagen = pro_imagen;
    }

    public Integer getPro_stock() {
        return pro_stock;
    }

    public void setPro_stock(Integer pro_stock) {
        this.pro_stock = pro_stock;
    }

    public String getPro_descripcion() {
        return pro_descripcion;
    }

    public void setPro_descripcion(String pro_descripcion) {
        this.pro_descripcion = pro_descripcion;
    }

    public Character getPro_disponible() {
        return pro_disponible;
    }

    public void setPro_disponible(Character pro_disponible) {
        this.pro_disponible = pro_disponible;
    }

    public Marca getMarca_id() {
        return marca_id;
    }

    public void setMarca_id(Marca marca_id) {
        this.marca_id = marca_id;
    }

    public Forma getForma_id() {
        return forma_id;
    }

    public void setForma_id(Forma forma_id) {
        this.forma_id = forma_id;
    }

    public Categoria getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(Categoria categoria_id) {
        this.categoria_id = categoria_id;
    }
}
