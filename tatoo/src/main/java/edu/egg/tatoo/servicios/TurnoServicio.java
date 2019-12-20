
package edu.egg.tatoo.servicios;

import edu.egg.tatoo.entidades.Proveedor;
import edu.egg.tatoo.entidades.Turno;
import edu.egg.tatoo.entidades.Usuario;
import edu.egg.tatoo.repositorios.TurnoRepositorio;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurnoServicio {
    @Autowired
    private TurnoRepositorio turnorepositorio;
    
    public Turno guardarTurno  (Proveedor proveedor, Usuario usuario, Date fecha){
        Turno turno = new Turno ();
        turno.setFecha(fecha);
        turno.setProveedor(proveedor);
        turno.setUsuario(usuario);
        
        return turno;

}
    
    
    
}
