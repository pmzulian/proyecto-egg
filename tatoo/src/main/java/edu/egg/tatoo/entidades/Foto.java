
package edu.egg.tatoo.entidades;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Foto {
    
@Id
@GeneratedValue(generator = "uuid")
@GenericGenerator (name = "uuid", strategy = "uuid2")
private String idfoto;
private String nombre ;
private String mime;

@ManyToOne
private Proveedor proveedor;
@ManyToOne
private Usuario usuario;

@Lob @Basic(fetch = FetchType.LAZY)
private byte[] contenido;

    public Foto() {
    }

    public String getId() {
        return idfoto;
    }

    public void setId(String id) {
        this.idfoto = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }


    public byte[] getContenido() {
        return contenido;
    }

    public void setContenido(byte[] contenido) {
        this.contenido = contenido;
    }

    public String getIdfoto() {
        return idfoto;
    }

    public void setIdfoto(String idfoto) {
        this.idfoto = idfoto;
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
