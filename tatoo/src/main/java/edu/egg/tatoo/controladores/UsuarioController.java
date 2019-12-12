
package edu.egg.tatoo.controladores;

import edu.egg.tatoo.entidades.Usuario;
import edu.egg.tatoo.servicios.UsuarioServicio;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Multipart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioServicio usuarioservicio;
    
    
    

    @GetMapping("/actualizacion")
    public String actualizacion(@RequestParam (required = false) String id, ModelMap modelo) {
        
        Usuario usuario;
        
        if(id != null){
            usuario = usuarioservicio.buscarPorID(id);
            modelo.put("usuario", usuario);
        }else{
            modelo.put("usuario", new Usuario());
        }
        
        return "registrousuario.html";
    }
    
    
    @PostMapping("/actualizar")
    public String in (@RequestParam MultipartFile archivo,
                      @RequestParam (required = false) String id,
                      @RequestParam Long documento, 
                      @RequestParam String nombre,
                      @RequestParam String apellido,
                      @RequestParam Long telefono,
                      @RequestParam String mail,
                      @RequestParam String contrasenia
                       ) throws Exception{
        
     
            usuarioservicio.actualizarUsuario(archivo, id, nombre, apellido, documento, telefono, mail, contrasenia);
      
        
        
    
            return  "redirect: /usuario/actualizacion";
            }   
    
}



//@PathVariable (value = "nombre") String nombre, 
//                      @PathVariable (value = "apellido")String aprellido,
//                      @PathVariable (value = "documento") Long documento,
//                      @PathVariable (value = "telefono") Long telefono,
//                      @PathVariable (value = "mail") String mail, 
//                      @PathVariable (value = "contrasenia") String contrasenia