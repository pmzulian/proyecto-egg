
package edu.egg.tatoo.entidades;

import javax.persistence.GeneratedValue;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Estilo {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator (name = "uuid", strategy = "uuid2")
    private String id;
    private String nombre;

    public Estilo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
