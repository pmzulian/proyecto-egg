
package edu.egg.tatoo.repositorios;

import org.springframework.data.repository.query.Param;
import edu.egg.tatoo.entidades.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository <Usuario, String> {
    @Query("SELECT c FROM Usuario c WHERE c.nombre LIKE %"+":nombre"+"%")
    public List<Usuario> BuscarUsuarioPorNombre(@Param("nombre")String nombre);
    
    @Query("SELECT c FROM Usuario c WHERE c.apellido LIKE %"+":apellido"+"%")
    public List<Usuario> BuscarUsuarioPorApellido(@Param("apellido")String apellido);
    
    @Query("SELECT c FROM Usuario c WHERE c.documento LIKE %"+":documento"+"%")
    public List<Usuario> BuscarUsuarioPorDocumento(@Param("documento")Long documento);    

    @Query("SELECT c FROM Usuario c WHERE c.telefono LIKE %"+":telefono"+"%")
    public List<Usuario> BuscarUsuarioPorTelefono(@Param("telefono")Long telefono);    
    
    @Query("SELECT c FROM Usuario c WHERE c.mail LIKE %"+":mail"+"%")
    public List<Usuario> BuscarUsuarioPorMail(@Param("mail")String mail);
    
    @Query("SELECT c FROM Usuario c WHERE c.mail LIKE %"+":mail"+"%")
    public Usuario BuscarUsuarioPorMailU(@Param("mail")String mail);
    
    @Query("SELECT c FROM Usuario c WHERE c.id LIKE %"+":id"+"%")
    public List<Usuario> buscarporId(@Param("id")String id);
    
    
    
    }
