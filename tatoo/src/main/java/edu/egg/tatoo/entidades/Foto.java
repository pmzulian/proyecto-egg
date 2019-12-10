
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

    /**
     * @return the contenido
     */
    public byte[] getContenido() {
        return contenido;
    }

    /**
     * @param contenido the contenido to set
     */
    public void setContenido(byte[] contenido) {
        this.contenido = contenido;
    }

 

    


}
