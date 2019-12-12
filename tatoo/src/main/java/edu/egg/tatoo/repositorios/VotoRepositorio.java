package edu.egg.tatoo.repositorios;

import edu.egg.tatoo.entidades.Voto;
import org.springframework.data.repository.query.Param;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VotoRepositorio extends JpaRepository <Voto, String> {
    @Query("SELECT c FROM Voto c WHERE c.id LIKE %"+":calificacion"+"%")
    public List<Voto> BuscarVotoPorCalificacion(@Param("calificacion")int calificacion);
}


