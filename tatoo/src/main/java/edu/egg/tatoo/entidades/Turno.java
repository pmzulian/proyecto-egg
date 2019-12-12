
package edu.egg.tatoo.entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Turno {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator (name = "uuid", strategy = "uuid2")
    private String id;
    @Temporal(TemporalType.DATE)
    private Date fecha ;
    
    @ManyToOne
    private Proveedor proveedor;
    @ManyToOne
    private Usuario usuario;
   
    public Turno() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    



    
    
    
}
