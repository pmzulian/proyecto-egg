package edu.egg.tatoo.entidades;

import java.util.List;
import java.util.Set;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String nombre;
    private String apellido;
    private Long documento;
    private Long telefono;
    private String mail;
    private String contrasenia;
    @OneToOne
    private Ubicacion ubicacion;

//@OneToMany(targetEntity = Turno.class, mappedBy = "usuario", fetch = FetchType.EAGER)
    @OneToMany
    private List<Turno> turno;

//@OneToMany(targetEntity = Voto.class, mappedBy = "usuario", fetch = FetchType.EAGER)
    @OneToMany
    private List<Voto> voto;

//@OneToMany(targetEntity = PregResp.class, mappedBy = "usuario", fetch = FetchType.EAGER)
    @OneToMany
    private List<PregResp> pregresp;

//@OneToMany(targetEntity = Foto.class, mappedBy = "usuario", fetch = FetchType.EAGER)
    @OneToOne
    private Foto foto;
    
//@OneToOne(fetch = FetchType.EAGER)
//@JoinTable(name="authorities_users",
//joinColumns=@JoinColumn(name="usuario_id"),
//inverseJoinColumns=@JoinColumn(name="authority_id"))
//private Authority authority;


    public Usuario() {
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

    public List<Turno> getTurno() {
        return turno;
    }

    public void setTurno(List<Turno> turno) {
        this.turno = turno;
    }

    public List<Voto> getVoto() {
        return voto;
    }

    public void setVoto(List<Voto> voto) {
        this.voto = voto;
    }

    public List<PregResp> getPregresp() {
        return pregresp;
    }

    public void setPregresp(List<PregResp> pregresp) {
        this.pregresp = pregresp;
    }

    public Foto getFoto() {
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }

//    public Authority getAuthority() {
//        return authority;
//    }
//
//    public void setAuthority(Authority authority) {
//        this.authority = authority;
//    }

}
