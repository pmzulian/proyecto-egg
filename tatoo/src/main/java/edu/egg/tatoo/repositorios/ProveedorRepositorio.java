package edu.egg.tatoo.repositorios;

import edu.egg.tatoo.entidades.Proveedor;
import edu.egg.tatoo.entidades.Usuario;
import org.springframework.data.repository.query.Param;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepositorio extends JpaRepository <Proveedor, String> {
//    @Query("SELECT c FROM Proveedor c WHERE c.nombre LIKE %"+":nombre"+"%")
//    public List<Proveedor> BuscarProveedorPorNombre(@Param("nombre")String nombre);
//    
//    public Proveedor findByNombre(String nombre);
//    
//    @Query("SELECT c FROM Proveedor c WHERE c.apellido LIKE %"+":apellido"+"%")
//    public List<Proveedor> BuscarProveedorPorApellido(@Param("apellido")String apellido);
//    
//    @Query("SELECT c FROM Proveedor c WHERE c.documento LIKE %"+":documento"+"%")
//    public List<Proveedor> BuscarProveedorPorDocumento(@Param("documento")Long documento);    
//
//    @Query("SELECT c FROM Proveedor c WHERE c.telefono LIKE %"+":telefono"+"%")
//    public List<Proveedor> BuscarProveedorPorTelefono(@Param("telefono")Long telefono);    
//    
    @Query("SELECT c FROM Proveedor c WHERE c.mail LIKE %"+":mail"+"%")
    public Proveedor BuscarProveedorPorMail(@Param("mail")String mail);
    
    @Query("SELECT c FROM Usuario c WHERE c.id LIKE %"+":id"+"%")
    public List<Proveedor> buscarporId(@Param("id")String id);
    
    public Proveedor findBymail (String mail);  
    
    @Query ("SELECT c FROM Proveedor c WHERE (c.ubicacion.nombre = :nombre) OR (c.ubicacion.municipio_nombre = :municipio)")
    public List <Proveedor> listarporZona(@Param("nombre") String nombre, @Param("municipio")String barrio);
    
    @Query("SELECT c FROM Proveedor c WHERE c.estilos.nombre = :estilo")
    public List <Proveedor> listarporEstilo (@Param("estilo")String estilo);
    
//        @Query ("SELECT c FROM Proveedor c INNER JOIN Ubicacion u ON c.Ubicacion_id = u.id WHERE c.ubicacion.nombre = :nombre AND c.ubicacion.municipio_nombre = :municipio")
//    public List <Proveedor> listarporZona(@Param("nombre") String nombre, @Param("municipio")String barrio);

}