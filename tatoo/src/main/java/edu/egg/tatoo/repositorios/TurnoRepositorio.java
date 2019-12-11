package edu.egg.tatoo.repositorios;

import edu.egg.tatoo.entidades.Turno;
import java.util.Date;
import org.springframework.data.repository.query.Param;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnoRepositorio extends JpaRepository <Turno, String> {
//    @Query("SELECT c FROM Turno c WHERE c.id LIKE %"+":id"+"%")
//    public List<Turno> BuscarTurnoPorId(@Param("id")String id);
//    
//    @Query("SELECT c FROM Turno c WHERE c.fecha LIKE %"+":fecha"+"%")
//    public List<Turno> BuscarTurnoPorFecha(@Param("fecha")Date fecha);
}
