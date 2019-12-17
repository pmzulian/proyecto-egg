
package edu.egg.tatoo.controladores;

import edu.egg.tatoo.entidades.Proveedor;
import edu.egg.tatoo.entidades.Ubicacion;
import edu.egg.tatoo.entidades.Usuario;
import edu.egg.tatoo.errores.errorServicios;
import edu.egg.tatoo.servicios.ProveedorServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
    
    @GetMapping("/actualizacion")
    public String actualizacion  (@RequestParam (required = false )String id, ModelMap modelo){
        Proveedor proveedor;
        
        if(id != null){
            proveedor = proveedorservicio.buscarProID(id);
            modelo.put("proveedor", proveedor);
        }else{
            modelo.put("proveedor", new Proveedor ());
        }
        
        return "registro.html";
        
    }
    
    @PostMapping("/actualizar")
    public String actualizar (@RequestParam MultipartFile archivo,
                              @RequestParam (required = false) String id,
                              @RequestParam Long documento,
                              @RequestParam String nombre,
                              @RequestParam String apellido,
                              @RequestParam Long telefono,
                              @RequestParam String mail,
                              @RequestParam String contrasenia,
                              @RequestParam Ubicacion ubicacion
                                ) throws Exception{
       
        proveedorservicio.actualizarProveedor(archivo, id, documento, nombre, apellido, mail, contrasenia, telefono, ubicacion);
        return null;
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
    
    @GetMapping("/eliminar")
    public String eliminar (@RequestParam String id) throws errorServicios{
        proveedorservicio.borrarProveedor(id);
        return null;
    }
    
    
    
    
}
