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
    
//    @Query ("SELECT p FROM proveedor_estilo pr\n" +
//            "INNER JOIN estilo e\n" +
//            "ON pr.estilo_id = e.id\n" +
//            "INNER JOIN proveedor p\n" +
//            "ON pr.proveedor_id=p.id\n" +
//            "INNER JOIN ubicacion u\n" +
//            "ON p.ubicacion_id = u.id\n" +
//            "p.estilos"
//"WHERE (e.nombre = :estilo) AND (u.provincia_nombre = :provincia_nombre)")
//    public List <Proveedor> busquedaProveedores(@Param("estilo") String estilo, @Param("provincia_nombre") String provincia_nombre);
//    
    
//    public List <Proveedor> findByEstilo(String estilo,String Ubicacion);
 
    
//    
//    @Query("SELECT c FROM Proveedor c INNER JOIN Estilo e ON c.estilo = e.nombre WHERE e.nombre LIKE %"+":nombre"+"%")
//    public List<Proveedor> BuscarProveedorPorEstilo(@Param("nombre")String nombre);
}
