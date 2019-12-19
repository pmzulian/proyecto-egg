package edu.egg.tatoo.controladores;

import edu.egg.tatoo.entidades.Proveedor;
import edu.egg.tatoo.entidades.Ubicacion;
import edu.egg.tatoo.entidades.Usuario;
import edu.egg.tatoo.errores.errorServicios;
import edu.egg.tatoo.repositorios.ProveedorRepositorio;
import edu.egg.tatoo.repositorios.UbicacionRepositorio;
import edu.egg.tatoo.repositorios.UsuarioRepositorio;
import edu.egg.tatoo.servicios.UsuarioServicio;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Multipart;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/usuario")
public class UsuarioController extends HttpServlet {

    @Autowired
    private UsuarioServicio usuarioservicio;
    
    @Autowired
    private UsuarioRepositorio ur;
    
    @Autowired
    private ProveedorRepositorio pr;
    

    @GetMapping("/actualizacion")
    public String actualizacion(@RequestParam(required = false) String id, ModelMap modelo) {

        Usuario usuario;

        if (id != null) {
            usuario = usuarioservicio.buscarPorID(id);
            modelo.put("usuario", usuario);
        } else {
            modelo.put("usuario", new Usuario());
        }
        
        

        return "registro.html";
    }

    @PostMapping("/actualizar")
        public String actualizar(@RequestParam MultipartFile archivo,
            @RequestParam(required = false) String id,
            @RequestParam Long documento,
            @RequestParam String nombre,
            @RequestParam String apellido,
            @RequestParam Long telefono,
            @RequestParam String mail,
            @RequestParam String contrasenia
    ) throws Exception {
       

        usuarioservicio.actualizarUsuario(archivo, id, nombre, apellido, documento, telefono, mail, contrasenia);
      
        return "redirect:/tatoo/index";
    }
    
    @PostMapping("/entrar")
    public String entrar(@RequestParam String mail, @RequestParam String password, ModelMap modelo, HttpSession session) {
        System.out.println("ARRANCA O NO ARRANCA?");
         Usuario usuario = null;
        
         try{
             usuario = ur.findBymail(mail);
         }catch(NullPointerException e){
             System.out.println("No encuentro usuario");
   
         }
        
      
        
        if (usuario!=null){
            
            session.setAttribute("User", usuario);
            
        if(new BCryptPasswordEncoder().matches(password, usuario.getContrasenia())){
            
            modelo.put("usuario", usuario);
            return "menuusuario.html";
        }   
        }
       
        Proveedor proveedor = pr.BuscarProveedorPorMail(mail);
        
        if (proveedor != null) {
            
            session.setAttribute("User", proveedor);
            
             if(new BCryptPasswordEncoder().matches(password, proveedor.getContrasenia())){
            
            modelo.put("proveedor", proveedor);
            return "menuproveedor.html";
             }
            
        }
       
        
        
        return "redirect:/tatoo/login";
    }

    @GetMapping(value = "/image/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable(value = "id") String id) {

        Usuario usuario = null;
        usuario = usuarioservicio.buscarPorID(id);

        byte[] foto = usuario.getFoto().getContenido();
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<byte[]>(foto, headers, HttpStatus.OK);

    }   

    @GetMapping("/listado{id}")
    public String listado(@RequestParam(required = false) String q, ModelMap modelo) {
        List<Usuario> usuarios;
       
        if (q != null) {
            usuarios = usuarioservicio.buscarporId(q);
        } else {
            usuarios = usuarioservicio.listarusuarios();
        }
        modelo.put("q", q);
        modelo.put("usuarios", usuarios);

        return "enzopruebaLista.html";

    }

    @GetMapping("/eliminar")
    public String eliminar(@RequestParam String id) throws errorServicios {
        usuarioservicio.borrarUsuario(id);
        return "pruebaLista.html";
    }
    


}

//                      @PathVariable (value = "nombre") String nombre, 
//                      @PathVariable (value = "apellido")String aprellido,
//                      @PathVariable (value = "documento") Long documento,
//                      @PathVariable (value = "telefono") Long telefono,
//                      @PathVariable (value = "mail") String mail, 
//                      @PathVariable (value = "contrasenia") String contrasenia
