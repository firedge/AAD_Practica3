package com.firedge.hibernate;
// Generated Jan 29, 2015 8:47:15 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Inmueble generated by hbm2java
 */
public class Inmueble  implements java.io.Serializable {


     private Integer id;
     private String localidad;
     private String direccion;
     private String tipo;
     private BigDecimal precio;
     private String usuario;
     private Set fotoses = new HashSet(0);

    public Inmueble() {
    }

	
    public Inmueble(String localidad, String direccion, String tipo, BigDecimal precio, String usuario) {
        this.localidad = localidad;
        this.direccion = direccion;
        this.tipo = tipo;
        this.precio = precio;
        this.usuario = usuario;
    }
    public Inmueble(String localidad, String direccion, String tipo, BigDecimal precio, String usuario, Set fotoses) {
       this.localidad = localidad;
       this.direccion = direccion;
       this.tipo = tipo;
       this.precio = precio;
       this.usuario = usuario;
       this.fotoses = fotoses;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getLocalidad() {
        return this.localidad;
    }
    
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public BigDecimal getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public Set getFotoses() {
        return this.fotoses;
    }
    
    public void setFotoses(Set fotoses) {
        this.fotoses = fotoses;
    }

    @Override
    public String toString() {
        return "Inmueble{" + "id=" + id + ", localidad=" + localidad + ", direccion=" + direccion + ", tipo=" + tipo + ", precio=" + precio + ", usuario=" + usuario + ", fotoses=" + fotoses + '}';
    }

    


}


