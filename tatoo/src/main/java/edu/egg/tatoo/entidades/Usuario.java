package edu.egg.tatoo.entidades;

import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Usuario {

  
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String nombre;
    private String apellido;
    private Long documento;
    private String contrasenia;
    private Long telefono;
    private String mail;
    @OneToOne
    private Ubicacion ubicacion;

    private Turno[] turno;

    private Voto[] voto;

    private PregResp[] pregresp;

    private Foto[] foto;

    public Usuario() {
    }
    
    @Id
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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
        return mail;
    }

    public void setMail(String Mail) {
        this.mail = Mail;
    }

//    @OneToOne(targetEntity = Ubicacion.class, mappedBy = "usuario", fetch = FetchType.EAGER)

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Long getDocumento() {
        return documento;
    }

    public void setDocumento(Long documento) {
        this.documento = documento;
    }

    @OneToMany(targetEntity = Turno.class, mappedBy = "usuario", fetch = FetchType.EAGER)

    public Turno[] getTurno() {
        return turno;
    }

    public void setTurno(Turno[] turno) {
        this.turno = turno;
    }

    @OneToMany(targetEntity = Voto.class, mappedBy = "usuario", fetch = FetchType.EAGER)

    public Voto[] getVoto() {
        return voto;
    }

    public void setVoto(Voto[] voto) {
        this.voto = voto;
    }

    @OneToMany(targetEntity = PregResp.class, mappedBy = "usuario", fetch = FetchType.EAGER)

    public PregResp[] getPregresp() {
        return pregresp;
    }

    public void setPregresp(PregResp[] pregresp) {
        this.pregresp = pregresp;
    }

    @OneToMany(targetEntity = Foto.class, mappedBy = "usuario", fetch = FetchType.EAGER)

    public Foto[] getFoto() {
        return foto;
    }

    public void setFoto(Foto[] foto) {
        this.foto = foto;
    }

}
