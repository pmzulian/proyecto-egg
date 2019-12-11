package edu.egg.tatoo.entidades;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Proveedor {

@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String nombre;
    private String apellido;
    private Long documento;
    private String contrasenia;
    private Long telefono;
    private String Mail;
    @OneToOne
    private Ubicacion ubicacion;
@OneToMany(targetEntity = Turno.class, mappedBy = "proveedor", fetch = FetchType.EAGER)
    private List<Turno> turno;
@OneToMany(targetEntity = Voto.class, mappedBy = "proveedor", fetch = FetchType.EAGER)
    private List<Voto> voto;
@OneToMany(targetEntity = PregResp.class, mappedBy = "proveedor", fetch = FetchType.EAGER)
    private List<PregResp> pregresp;

@OneToMany(targetEntity = Estilo.class, mappedBy = "proveedor", fetch = FetchType.EAGER)
    private List<Estilo> estilo;

@OneToMany(targetEntity = Foto.class, mappedBy = "proveedor", fetch = FetchType.EAGER)
    private List<Foto> foto;

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
        return Mail;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }

//    @OneToOne (targetEntity=Ubicacion.class, mappedBy="proveedor", fetch=FetchType.EAGER)
    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<Estilo> getEstilo() {
        return estilo;
    }

    public void setEstilo(List<Estilo> estilo) {
        this.estilo = estilo;
    }

    public List<Foto> getFoto() {
        return foto;
    }

    public void setFoto(List<Foto> foto) {
        this.foto = foto;
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

}
