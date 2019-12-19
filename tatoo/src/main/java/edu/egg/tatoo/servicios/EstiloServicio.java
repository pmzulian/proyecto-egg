
package edu.egg.tatoo.servicios;

import edu.egg.tatoo.entidades.Estilo;
import edu.egg.tatoo.entidades.Foto;
import edu.egg.tatoo.repositorios.EstiloRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class EstiloServicio{

    
    @Autowired
    private EstiloRepositorio estilorepositorio;
    
    public List mostrarEstilos () {
        return estilorepositorio.findAll();
    }
    
    
    public Estilo crearEstilo (String nombre){
        Estilo estilo = new Estilo ();
        estilo.setNombre(nombre);
        return estilorepositorio.save(estilo);
    }
    
//    public List buscarEstiloporNombre (String nombre){
//        return estilorepositorio.BuscarEstiloPorNombre(nombre);
//    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     
    }

    
    
    
    
    
    
    

