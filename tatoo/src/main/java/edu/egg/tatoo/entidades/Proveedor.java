package edu.egg.tatoo.entidades;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table (name= "proveedor")
public class Proveedor implements Serializable{

    @Id
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
    @JoinColumn(name="ubicacion_id")
    private Ubicacion ubicacion;
//@OneToMany(targetEntity = Turno.class, mappedBy = "proveedor", fetch = FetchType.EAGER)
    @OneToMany
    private List<Turno> turno;
//@OneToMany(targetEntity = Voto.class, mappedBy = "proveedor", fetch = FetchType.EAGER)
    @OneToMany
    private List<Voto> voto;
//@OneToMany(targetEntity = PregResp.class, mappedBy = "proveedor", fetch = FetchType.EAGER)
    @OneToMany
    private List<PregResp> regresp;
//@OneToMany(targetEntity = Estilo.class, mappedBy = "proveedor", fetch = FetchType.EAGER)
    @OneToOne (cascade = {CascadeType.ALL})
    @JoinColumn (name="estilos_id") 
    private Estilo estilos;
    
    @OneToOne
    private Foto fotoPerfil;
    @OneToMany 
    private List <Foto> fotoPortfolio;

    public Proveedor() {
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

    public Long getDocumento() {
        return documento;
    }

    public void setDocumento(Long documento) {
        this.documento = documento;
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

    public void setMail(String mail) {
        this.mail = mail;
    }

//    @OneToOne (targetEntity=Ubicacion.class, mappedBy="proveedor", fetch=FetchType.EAGER)
    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
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

    public List<PregResp> getRegresp() {
        return regresp;
    }

    public void setRegresp(List<PregResp> regresp) {
        this.regresp = regresp;
    }
    
    public Foto getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(Foto fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public List <Foto> getFotoPortfolio() {
        return fotoPortfolio;
    }

    public void setFotoPortfolio(List <Foto> fotoPortfolio) {
        this.fotoPortfolio = fotoPortfolio;
    }

    public Estilo getEstilos() {
        return estilos;
    }

    public void setEstilos(Estilo estilos) {
        this.estilos = estilos;
    }
    
}
