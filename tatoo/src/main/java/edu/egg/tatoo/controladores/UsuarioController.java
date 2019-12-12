
package edu.egg.tatoo.controladores;

import edu.egg.tatoo.servicios.UsuarioServicio;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Multipart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioServicio usuarioservicio;
    
    @GetMapping("/")
    public String registrar(){
        return "registrousuario.html";
    }
    
    @GetMapping("/in")
    public String in (@RequestParam MultipartFile archivo,
                      @RequestParam (required = false) String id,
                      @RequestParam Long documento, 
                      @RequestParam String nombre,
                      @RequestParam String apellido,
                      @RequestParam String domicilio,
                      @RequestParam Long telefono,
                      @RequestParam String mail,
                      @RequestParam String contrasenia
                        ){
        
        try {
            usuarioservicio.actualizarUsuario(archivo, id, nombre, apellido, documento, telefono, mail, contrasenia);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    
        return null;
    }   
    
}



//@PathVariable (value = "nombre") String nombre, 
//                      @PathVariable (value = "apellido")String aprellido,
//                      @PathVariable (value = "documento") Long documento,
//                      @PathVariable (value = "telefono") Long telefono,
//                      @PathVariable (value = "mail") String mail, 
//                      @PathVariable (value = "contrasenia") String contrasenia