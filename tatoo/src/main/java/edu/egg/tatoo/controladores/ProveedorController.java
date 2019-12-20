
package edu.egg.tatoo.controladores;

import edu.egg.tatoo.entidades.PregResp;
import edu.egg.tatoo.entidades.Proveedor;
import edu.egg.tatoo.entidades.Ubicacion;
import edu.egg.tatoo.entidades.Usuario;
import edu.egg.tatoo.errores.errorServicios;
import edu.egg.tatoo.repositorios.PregRespRepositorio;
import edu.egg.tatoo.repositorios.ProveedorRepositorio;
import edu.egg.tatoo.repositorios.UbicacionRepositorio;
import edu.egg.tatoo.servicios.ProveedorServicio;
import edu.egg.tatoo.servicios.UsuarioServicio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
@RequestMapping ("/proveedor")
public class ProveedorController {
    
    @Autowired
    private ProveedorServicio proveedorservicio ;
    
    @Autowired
    private PregRespRepositorio pregrespRepopsitorio;
    
    @Autowired
    private ProveedorRepositorio pr;
    
    @Autowired
    private UbicacionRepositorio ur;
    
    @Autowired 
    private UsuarioServicio usuarioServicio;
    
    @GetMapping("/actualizacion")
    public String actualizacion  (@RequestParam (required = false )String id, ModelMap modelo){

        Proveedor proveedor;
        
        if(id != null){
            proveedor = proveedorservicio.buscarProID(id);
            modelo.put("proveedor", proveedor);
        }else{
            modelo.put("proveedor", new Proveedor ());
        }
            modelo.put("proveedor", ur.findAll());
        
        
        return "registrop.html";
        
    }
    
    @PostMapping("/actualizar")
    public String actualizar (@RequestParam MultipartFile archivo,
                              @RequestParam (required = false) String id,
                              @RequestParam Long documento,
                              @RequestParam String nombre,
                              @RequestParam String apellido,
                              @RequestParam String mail,
                              @RequestParam String contrasenia,
                              @RequestParam Long telefono,
                              @RequestParam String departamento,
                              @RequestParam String localidad,
                              @RequestParam String estilo
                                ) throws Exception{
       
        proveedorservicio.actualizarProveedor(archivo, id, documento, nombre, apellido, mail, contrasenia, telefono, departamento, localidad, estilo);
        return "redirect:/tatoo/login";
    }
    
    @GetMapping(value = "/image/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable(value = "id") String id) {

        Proveedor proveedor = null;
        proveedor = proveedorservicio.buscarProID(id);

        byte[] foto = proveedor.getFotoPerfil().getContenido();
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<byte[]>(foto, headers, HttpStatus.OK);

    }
    
    
    
    @PostMapping("/entrar")
    public String entrar(@RequestParam String mail, @RequestParam String password, ModelMap modelo, HttpSession session) {
        
       
        Proveedor proveedor = pr.findBymail(mail);
        
        if (proveedor!=null){
            
            session.setAttribute("User", proveedor);
            
        if(new BCryptPasswordEncoder().matches(password, proveedor.getContrasenia())){
            
            modelo.put("proveedor", proveedor);
            return "enzomenu.html";
        }   
        }else{
            return "redirect:/tatoo/login";
        }
        
        return "redirect:/tatoo/login";
    }
    
    @GetMapping("/listado{id}")
    public String listado (@RequestParam (required = false) String q, ModelMap modelo){
        
        List <Proveedor> proveedores;
        
        if(q != null){
            proveedores = proveedorservicio.buscarPorIDL(q);
        }else {
            proveedores = proveedorservicio.listarProveedor();
        }
        modelo.put("q", q);
        modelo.put("proveedores", proveedores);

        
        return null;
    }
    
    
    @GetMapping("/listarporzona")
    public String listar (
                          @RequestParam (required = false) String localidad,
                          @RequestParam (required = false) String barrio,
                          Model modelo){
        List <Proveedor> tatuadores ;
        tatuadores = proveedorservicio.listarporZona(localidad, barrio);
        modelo.addAttribute("tatuadores", tatuadores);
        System.out.println(tatuadores.get(0).getNombre());
        
        return "proveedorlistarporZona.html";
    }
   
    @GetMapping("/listarporestilo")
    public String listar2 (@RequestParam String estilo,
                           Model modelo){
        List <Proveedor> tatuadores;
        tatuadores = proveedorservicio.listarporEstilo(estilo);
        modelo.addAttribute("tatuadores", tatuadores);
        
        return "proveedorlistaporEstilo.html";
        
    }
    
    
    @GetMapping("/eliminar")
    public String eliminar (@RequestParam String id) throws errorServicios{
        proveedorservicio.borrarProveedor(id);
        return null;
    }
    
    @GetMapping("/turno")
    public void turno (@RequestParam String idp, @RequestParam String idc){
        Proveedor proveedor=proveedorservicio.buscarProID(idp);
        Usuario usuario = usuarioServicio.buscarPorID(idc);
  
        try {
            proveedorservicio.asignarTurno(null, null, null);
        } catch (Exception ex) {
            Logger.getLogger(ProveedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @GetMapping("/mensaje")
    public String Mensaje (@RequestParam String nombre, @RequestParam String mensaje) throws errorServicios{
        System.out.println("paso1");
        List <PregResp> listado = new ArrayList <> ();
         
        Proveedor proveedor;
        proveedor = pr.BuscarProveedorPorNombre(nombre);
        
         if(proveedor == null){
             throw new errorServicios("No se encuentra el tatuador");
         }
        System.out.println("paso2");
         PregResp pregunta = new PregResp ();
         pregunta.setPregunta(mensaje);
         pregunta =pregrespRepopsitorio.save(pregunta);
        
         
         
         if(pregunta != null){
         
         listado.add(pregunta);  
         
         }else{
             throw new errorServicios ("no se puede settear la pregunta");
         }
         System.out.println("paso3");

         
         proveedor.setRegresp(listado);
        
        
        return "redirect:/tatoo/index";
    }

    
    

    
    
    
    
}
