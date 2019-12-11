package edu.egg.tatoo.servicios;

import edu.egg.tatoo.entidades.PregResp;
import edu.egg.tatoo.errores.errorServicios;
import edu.egg.tatoo.repositorios.PregRespRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PregRespServicio {
    
    @Autowired
    private PregRespRepositorio pgrepsitorio;
    
    
    
    public void preg (String x, String id) {
        PregResp pregresp = null ;
        
        if (id != null && id.isEmpty()){
            pregresp = pgrepsitorio.getOne(id);
        }
        if (pregresp == null) {
            pregresp = new PregResp ();
        }
        
        pregresp.setPregunta(x);
        pgrepsitorio.save(pregresp);

    }
    
        
    public void resp (String x, String id) throws Exception {
        PregResp pregresp = null ;
        
        if (id != null && id.isEmpty()){
            pregresp = pgrepsitorio.getOne(id);
        }
      
        if (pregresp == null){
            throw new Exception ("No existe una pregunta a responder.");
        }
        
        pregresp.setRespuesta(x);
        pgrepsitorio.save(pregresp);

    }
    
    
    

    public void validar(String nombre) throws errorServicios {
        if (nombre == null || nombre.isEmpty()) {
            throw new errorServicios("El nombre esta vacio o es nulo.");
        }
    }

    private boolean validarnum(String nombre) {
        try {
            Integer.parseInt(nombre);
            return false;
        } catch (NumberFormatException nfe) {
            return true;
        }
    }

}
