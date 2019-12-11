package edu.egg.tatoo.servicios;

import edu.egg.tatoo.entidades.Ubicacion;
import edu.egg.tatoo.errores.errorServicios;
import edu.egg.tatoo.repositorios.UbicacionRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UbicacionServicio {

    @Autowired
    private UbicacionRepositorio ubicacionrepositorio;

    public List<Ubicacion> listarUbicaciones() {
        return ubicacionrepositorio.findAll();
    }
//    
//    public List <Ubicacion> buscarporDepartamento(String nombre){
//        return ubicacionrepositorio.BuscarUbicacionPorDepartamento(nombre);  
//    }
//    
//    public List <Ubicacion> buscaporporProvincia (String nombre){
//        return ubicacionrepositorio.BuscarUbicacionPorNombreDeProvincia(nombre);
//    }
//    
//    public List <Ubicacion> buscarporBarrio (String nombre){
//        return ubicacionrepositorio.BuscarUbicacionPorBarrio(nombre);
//    }
//    
//    public List <Ubicacion> buscarporMunicipio (String nombre){
//        return ubicacionrepositorio.BuscarUbicacionPorMunicipio(nombre);
//    }
//
//    public void validar(String nombre) throws errorServicios {
//        if (nombre == null || nombre.isEmpty()) {
//            throw new errorServicios("El nombre esta vacio o es nulo.");
//        }
//    }

    private boolean validarnum(String nombre) {
        try {
            Integer.parseInt(nombre);
            return false;
        } catch (NumberFormatException nfe) {
            return true;
        }
    }
}
