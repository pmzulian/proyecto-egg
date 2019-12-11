package edu.egg.tatoo.repositorios;
import edu.egg.tatoo.entidades.Foto;
import org.springframework.data.repository.query.Param;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FotoRepositorio extends JpaRepository <Foto, String> {
//    @Query("SELECT c FROM Foto c WHERE c.nombre LIKE %"+":nombre"+"%")
//    public List<Foto> BuscarFotoPorNombre(@Param("nombre")String nombre);
    
}