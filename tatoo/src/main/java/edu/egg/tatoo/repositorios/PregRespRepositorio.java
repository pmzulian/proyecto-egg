
package edu.egg.tatoo.repositorios;

import edu.egg.tatoo.entidades.PregResp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PregRespRepositorio extends JpaRepository <PregResp, String>  {
    
}
