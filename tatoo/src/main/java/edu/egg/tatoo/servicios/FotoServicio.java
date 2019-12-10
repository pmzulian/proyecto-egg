
package edu.egg.tatoo.servicios;

import edu.egg.tatoo.entidades.Foto;
import edu.egg.tatoo.entidades.Usuario;
import edu.egg.tatoo.repositorios.FotoRepositorio;
import edu.egg.tatoo.repositorios.UsuarioRepositorio;
import java.io.IOException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FotoServicio {

    @Autowired 
    private UsuarioRepositorio usuariorepositorio;
    @Autowired
    private FotoRepositorio fotoRepositorio;
public Foto AgregarFoto (MultipartFile archivo) throws IOException{
   if(archivo != null){
          Foto foto = new Foto() ;
          foto.setMime(archivo.getContentType());
          foto.setNombre(archivo.getName());
          foto.setContenido(archivo.getBytes());
          return fotoRepositorio.save(foto);
          
           
        }else{
              return null;
        }
}
public void EliminarFoto(String id, String idFoto){
    Optional<Foto> respuesta= fotoRepositorio.findById(idFoto);
    if(respuesta.isPresent()){
        Foto foto = respuesta.get();
        if(foto.getId()!= null){
            foto.setContenido(null);
            fotoRepositorio.save(foto);
        }
    }
}
}
   
            
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
