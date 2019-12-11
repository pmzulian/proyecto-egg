
package edu.egg.tatoo.servicios;

import edu.egg.tatoo.repositorios.TurnoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurnoServicio {
    @Autowired
    private TurnoRepositorio turnorepositorio;
    
}
