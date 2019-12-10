
package edu.egg.tatoo.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;


@Entity
public class Usuario {
    
    @Id    
    @GeneratedValue(generator = "uuid")
    @GenericGenerator (name = "uuid", strategy = "uuid2")
    private String id;
    private String nombre;
    private String apellido;
    private Long documento;
    private String contrasenia;
    private Long telefono ;
    private String mail;
    @OneToOne
    private Ubicacion ubicacion;
    @OneToMany 
    private Turno turno;
    @OneToMany
    private Voto voto;
    @OneToMany
    private PregResp pregresp;
    @OneToOne
    private Foto foto;

    public Voto getVoto() {
        return voto;
    }

    public void setVoto(Voto voto) {
        this.voto = voto;
    }
    
    

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

    public Long getDocumento() {
        return getDocumento();
    }

    public void setDocumento(Long aocumento) {
        this.setDocumento(aocumento);
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



    /**
     * @return the ubicacion
     */
    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    /**
     * @param ubicacion the ubicacion to set
     */
    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * @return the turno
     */
    public Turno getTurno() {
        return turno;
    }

    /**
     * @param turno the turno to set
     */
    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    /**
     * @return the pregresp
     */
    public PregResp getPregresp() {
        return pregresp;
    }

    /**
     * @param pregresp the pregresp to set
     */
    public void setPregresp(PregResp pregresp) {
        this.pregresp = pregresp;
    }

    /**
     * @return the foto
     */
    public Foto getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(Foto foto) {
        this.foto = foto;
    }
    
    
    
    
    
}