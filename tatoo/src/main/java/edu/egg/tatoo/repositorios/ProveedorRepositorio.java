package edu.egg.tatoo.repositorios;

import edu.egg.tatoo.entidades.Proveedor;
import org.springframework.data.repository.query.Param;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepositorio extends JpaRepository <Proveedor, String> {
    @Query("SELECT c FROM Proveedor c WHERE c.nombre LIKE %"+":nombre"+"%")
    public List<Proveedor> BuscarProveedorPorNombre(@Param("nombre")String nombre);
    
    @Query("SELECT c FROM Proveedor c WHERE c.apellido LIKE %"+":apellido"+"%")
    public List<Proveedor> BuscarProveedorPorApellido(@Param("apellido")String apellido);
    
    @Query("SELECT c FROM Proveedor c WHERE c.documento LIKE %"+":documento"+"%")
    public List<Proveedor> BuscarProveedorPorDocumento(@Param("documento")Long documento);    

    @Query("SELECT c FROM Proveedor c WHERE c.telefono LIKE %"+":telefono"+"%")
    public List<Proveedor> BuscarProveedorPorTelefono(@Param("telefono")Long telefono);    
    
    @Query("SELECT c FROM Proveedor c WHERE c.mail LIKE %"+":mail"+"%")
    public List<Proveedor> BuscarProveedorPorMail(@Param("mail")String mail);
    
    @Query("SELECT c FROM Proveedor c INNER JOIN Estilo e ON c.estilo = e.nombre WHERE e.nombre LIKE %"+":nombre"+"%")
    public List<Proveedor> BuscarProveedorPorEstilo(@Param("nombre")String nombre);
}

