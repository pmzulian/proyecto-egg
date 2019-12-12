package edu.egg.tatoo.repositorios;

import edu.egg.tatoo.entidades.Estilo;
import org.springframework.data.repository.query.Param;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EstiloRepositorio extends JpaRepository <Estilo, String> {
    @Query("SELECT c FROM Estilo c WHERE c.nombre LIKE %"+":nombre"+"%")
    public List<Estilo> BuscarEstiloPorNombre(@Param("nombre")String nombre);
}