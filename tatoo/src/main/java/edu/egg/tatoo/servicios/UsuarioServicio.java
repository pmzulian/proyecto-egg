
package edu.egg.tatoo.servicios;

import edu.egg.tatoo.entidades.Foto;
import edu.egg.tatoo.entidades.Usuario;
import edu.egg.tatoo.errores.errorServicios;
import edu.egg.tatoo.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;


public class UsuarioServicio {
    @Autowired
    UsuarioRepositorio usuariorepositorio;   
    @Autowired
    FotoServicio fotoservicio;
     public void actualizarCliente(MultipartFile archivo, String id, Long documento, String nombre, String apellido, String domicilio, String telefono) throws errorServicios, Exception {
       
        Usuario usuario = null;
        
        if(id != null && id != "" && !id.isEmpty()){
            usuario = usuariorepositorio.getOne(id);
            
            
        }
        if(usuario == null){
            usuario = new Usuario () ;
        }
        if(nombre == null || nombre.trim().isEmpty()){
            throw new Exception("El nombre no puede ser nulo.");
        }
   
            usuario.setDocumento(documento);
            usuario.setNombre(nombre);
            usuario.setApellido(apellido);
          usuario.setContrasenia(nombre);
           usuario.setMail(id);
          usuario.setTelefono(documento);
          
            
             Foto foto =fotoservicio.AgregarFoto(archivo);
            usuario.setFoto(foto);
            usuariorepositorio.save(usuario);
            
      

    }
    
}
