package com.upn.PJ_TIENDA.entidad;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "u_id")
    private Integer u_id;

    @NotBlank(message = "Ingrese su Nombre, sino como sabemos..?")
    @Column(name = "u_nombres")
    private String u_nombres;

    @NotBlank(message = "Ingrese su Apellido Paterno, sino como sabemos..?")
    @Column(name = "u_Paterno")
    private String u_Paterno;

    @NotBlank(message = "Ingrese su Apellido Materno, sino como sabemos..?")
    @Column(name = "u_Materno")
    private String u_Materno;

    @NotBlank(message = "Ingrese el DNI sino como sabemos que es Ud.??")
    @Column(name = "u_dni", length = 8)
    @Size(min = 8, max = 8, message = "Debe contener 8 valores")
    @Pattern(regexp = "[\\d]{8}", message = "Solo numeros")
    private String u_dni;

    @NotBlank(message = "Ingrese su direccion, sino como sabemos..?")
    @Column(name = "u_Direccion")
    private String u_Direccion;

   // @NotBlank(message = "Ingrese su perfil, sino como sabemos..?")
    @Column(name = "u_perfil")
    private String u_perfil;

    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
            + "[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
            + "(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
            message = "Correo invalido")
    @Column(name = "u_correo")
    private String u_correo;

    @NotBlank(message = "Ingrese su Usuario, sino como sabemos..?")
    @Column(name = "username")
    private String username;

    @NotBlank(message = "Ingrese su Clave, sino como sabemos..?")
    @Column(name = "password")
    private String password;

    @Pattern(regexp = "[\\d]{7,}", message = "Numero de Telefono Invalido")
    @Column(name = "u_telefono")
    private String u_telefono;

    public Usuario() {

    }
    public Usuario(Integer u_id) {
        this.u_id = u_id;
    }

    public Usuario(String u_nombres, String u_Paterno, String u_Materno, String u_dni, String u_Direccion, String u_perfil, String u_correo, String username, String password, String u_telefono) {
        this.u_nombres = u_nombres;
        this.u_Paterno = u_Paterno;
        this.u_Materno = u_Materno;
        this.u_dni = u_dni;
        this.u_Direccion = u_Direccion;
        this.u_perfil = u_perfil;
        this.u_correo = u_correo;
        this.username = username;
        this.password = password;
        this.u_telefono = u_telefono;
    }



    public Usuario(Integer u_id, String u_nombres, String u_Paterno, String u_Materno, String u_dni, String u_Direccion, String u_perfil, String u_correo, String username, String password, String u_telefono) {
        this.u_id = u_id;
        this.u_nombres = u_nombres;
        this.u_Paterno = u_Paterno;
        this.u_Materno = u_Materno;
        this.u_dni = u_dni;
        this.u_Direccion = u_Direccion;
        this.u_perfil = u_perfil;
        this.u_correo = u_correo;
        this.username = username;
        this.password = password;
        this.u_telefono = u_telefono;
    }

   

    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }

    public String getU_nombres() {
        return u_nombres;
    }

    public void setU_nombres(String u_nombres) {
        this.u_nombres = u_nombres;
    }

    public String getU_Paterno() {
        return u_Paterno;
    }

    public void setU_Paterno(String u_Paterno) {
        this.u_Paterno = u_Paterno;
    }

    public String getU_Materno() {
        return u_Materno;
    }

    public void setU_Materno(String u_Materno) {
        this.u_Materno = u_Materno;
    }

    public String getU_dni() {
        return u_dni;
    }

    public void setU_dni(String u_dni) {
        this.u_dni = u_dni;
    }

    public String getU_Direccion() {
        return u_Direccion;
    }

    public void setU_Direccion(String u_Direccion) {
        this.u_Direccion = u_Direccion;
    }

    public String getU_perfil() {
        return u_perfil;
    }

    public void setU_perfil(String u_perfil) {
        this.u_perfil = u_perfil;
    }

    public String getU_correo() {
        return u_correo;
    }

    public void setU_correo(String u_correo) {
        this.u_correo = u_correo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getU_telefono() {
        return u_telefono;
    }

    public void setU_telefono(String u_telefono) {
        this.u_telefono = u_telefono;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.u_id);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.u_id, other.u_id)) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "Usuario{" + "u_id=" + u_id + '}';
//    }

    
    
     //private static final long SerialVersionUID = 1L;

    @Override
    public String toString() {
        return "Usuario{" + "u_id=" + u_id + ", u_nombres=" + u_nombres + ", u_Paterno=" + u_Paterno + ", u_Materno=" + u_Materno + ", u_dni=" + u_dni + ", u_Direccion=" + u_Direccion + ", u_perfil=" + u_perfil + ", u_correo=" + u_correo + ", username=" + username + ", password=" + password + ", u_telefono=" + u_telefono + '}';
    }
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "v_usuario_id")
    private Collection<Venta> ventaCollection;

    @XmlTransient
    public Collection<Venta> getVentaCollection() {
        return ventaCollection;
    }

    public void setVentaCollection(Collection<Venta> ventaCollection) {
        this.ventaCollection = ventaCollection;
    }

}
