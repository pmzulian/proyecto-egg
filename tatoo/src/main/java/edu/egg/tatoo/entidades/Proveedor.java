
package edu.egg.tatoo.entidades;

import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Proveedor {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator (name = "uuid", strategy = "uuid2")
    private String id;
    private String nombre;
    private String apellido;
    private Long documento;
    private String contrasenia;
    private Long telefono ;
    private String Mail;
    @OneToOne
    private Ubicacion ubicacion;
    @OneToMany 
    private Turno turno [];
    @OneToMany
    private Voto voto [];
    @OneToMany
    private PregResp pregresp [];
    @OneToMany
    private Estilo estilo [];
    @OneToMany
    private  List <Foto> foto;

    public Proveedor() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Long getDocumento() {
        return documento;
    }

    public void setAocumento(Long aocumento) {
        this.documento = aocumento;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }

    public Turno[] getTurno() {
        return turno;
    }

    public void setTurno(Turno[] turno) {
        this.turno = turno;
    }

    public Voto[] getVoto() {
        return voto;
    }

    public void setVoto(Voto[] voto) {
        this.voto = voto;
    }

    public PregResp[] getPregresp() {
        return pregresp;
    }

    public void setPregresp(PregResp[] pregresp) {
        this.pregresp = pregresp;
    }

    public Estilo[] getEstilo() {
        return estilo;
    }

    public void setEstilo(Estilo[] estilo) {
        this.estilo = estilo;
    }

    public List <Foto> getFoto() {
        return foto;
    }

    public void setFoto(List <Foto> foto) {
        this.foto = foto;
    }
    
    
    
    
}   
