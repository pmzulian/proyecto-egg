
package edu.egg.tatoo.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ubicacion {
    
    private String Categoria;
    private String Centroide_lat;
    private String Centroide_lon;
    private int Departanto_id;
    private String Departamento_nombre;
    @Id
    private Long id;
    private Long Localidad_pcensal_id;
    private String localidad_censal_nombre ;
    private Long municipio_id ;
    private String municipio_nombre;
    private String nombre;
    private int provincia_id ;
    private String provincia_nombre ;

    public Ubicacion() {
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public String getCentroide_lat() {
        return Centroide_lat;
    }

    public void setCentroide_lat(String Centroide_lat) {
        this.Centroide_lat = Centroide_lat;
    }

    public String getCentroide_lon() {
        return Centroide_lon;
    }

    public void setCentroide_lon(String Centroide_lon) {
        this.Centroide_lon = Centroide_lon;
    }

    public int getDepartanto_id() {
        return Departanto_id;
    }

    public void setDepartanto_id(int Departanto_id) {
        this.Departanto_id = Departanto_id;
    }

    public String getDepartamento_nombre() {
        return Departamento_nombre;
    }

    public void setDepartamento_nombre(String Departamento_nombre) {
        this.Departamento_nombre = Departamento_nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLocalidad_pcensal_id() {
        return Localidad_pcensal_id;
    }

    public void setLocalidad_pcensal_id(Long Localidad_pcensal_id) {
        this.Localidad_pcensal_id = Localidad_pcensal_id;
    }

    public String getLocalidad_censal_nombre() {
        return localidad_censal_nombre;
    }

    public void setLocalidad_censal_nombre(String localidad_censal_nombre) {
        this.localidad_censal_nombre = localidad_censal_nombre;
    }

    public Long getMunicipio_id() {
        return municipio_id;
    }

    public void setMunicipio_id(Long municipio_id) {
        this.municipio_id = municipio_id;
    }

    public String getMunicipio_nombre() {
        return municipio_nombre;
    }

    public void setMunicipio_nombre(String municipio_nombre) {
        this.municipio_nombre = municipio_nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getProvincia_id() {
        return provincia_id;
    }

    public void setProvincia_id(int provincia_id) {
        this.provincia_id = provincia_id;
    }

    public String getProvincia_nombre() {
        return provincia_nombre;
    }

    public void setProvincia_nombre(String provincia_nombre) {
        this.provincia_nombre = provincia_nombre;
    }
    
    
            
    
}
