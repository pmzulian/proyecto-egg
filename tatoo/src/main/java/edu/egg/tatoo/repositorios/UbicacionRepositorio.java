
package edu.egg.tatoo.repositorios;

import org.springframework.data.repository.query.Param;
import edu.egg.tatoo.entidades.Ubicacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UbicacionRepositorio extends JpaRepository<Ubicacion, String>{
    @Query("SELECT c FROM Ubicacion c WHERE c.Departamento_nombre LIKE %"+"c.Departamento_nombre"+"%")
    public List<Ubicacion> BuscarUbicacionPorDepartamento (@Param("Departamento_nombre") String Departamento_nombre);
    
    @Query("SELECT c FROM Ubicacion c WHERE c.municipio_nombre LIKE %"+"c.municipio_nombre"+"%")
    public List<Ubicacion> BuscarUbicacionPorMunicipio (@Param("municipio_nombre") String municipio_nombre);

    @Query("SELECT c FROM Ubicacion c WHERE c.nombre LIKE %"+"c.nombre"+"%")
    public List<Ubicacion> BuscarUbicacionPorBarrio (@Param("nombre") String nombre);

    @Query("SELECT c FROM Ubicacion c WHERE c.provincia_nombre LIKE %"+"c.provincia_nombre"+"%")
    public List<Ubicacion> BuscarUbicacionPorNombreDeProvincia (@Param("provincia_nombre") String provincia_nombre);
}
