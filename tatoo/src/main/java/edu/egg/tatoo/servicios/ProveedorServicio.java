package edu.egg.tatoo.servicios;

import edu.egg.tatoo.entidades.Estilo;
import edu.egg.tatoo.entidades.Foto;
import edu.egg.tatoo.entidades.Proveedor;
import edu.egg.tatoo.entidades.Turno;
import edu.egg.tatoo.entidades.Ubicacion;
import edu.egg.tatoo.entidades.Usuario;
import edu.egg.tatoo.errores.errorServicios;
import edu.egg.tatoo.repositorios.EstiloRepositorio;
import edu.egg.tatoo.repositorios.FotoRepositorio;
import edu.egg.tatoo.repositorios.ProveedorRepositorio;
import edu.egg.tatoo.repositorios.UbicacionRepositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Service;


@Service
public class ProveedorServicio  {

    @Autowired
    private ProveedorRepositorio proveedorrepositorio;

    @Autowired
    private FotoServicio fotoservicio;
    
    @Autowired
    private UbicacionRepositorio ur;
    
    @Autowired
    private EstiloServicio estiloServicio;
    
    @Transactional
    public void actualizarProveedor(MultipartFile archivo, String id, Long documento, String nombre, String apellido, String mail, String contrasenia, Long telefono, String departamento, String localidad, String estilo) throws errorServicios, Exception {

        Proveedor proveedor = null;
        Ubicacion ubicacion = null;
        ubicacion = ur.buscarparaProveedor(departamento, localidad);
        
        List <Estilo> aux = new ArrayList <> ();
        Estilo es = new Estilo ();
        es = estiloServicio.crearEstilo(estilo);
        aux.add(es);
        
 
        Proveedor respuesta = null;
        
        

        if (id != null && id != "" && !id.isEmpty()) {
            proveedor = proveedorrepositorio.getOne(id);

        }
        if (proveedor == null) {
            proveedor = new Proveedor();
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new Exception("El nombre no puede ser nulo.");
        }
        if(ubicacion == null){
            throw new Exception("La ubicacion no se encuentra");
        }else{ 
          proveedor.setUbicacion(ubicacion);
        }
        
        if (id == null ||  id.isEmpty()){
            try{
                respuesta = proveedorrepositorio.findBymail(mail);
            }catch(NullPointerException e){
                e.toString();
            }
            try{
                
                if (respuesta.getMail().equals(mail)){
                throw new Exception ("Este usuario ya existe.");
                
            }
                
            }catch(NullPointerException e){
                e.toString();
            }
            
        }
        
        
        
        
        proveedor.setDocumento(documento);
        proveedor.setNombre(nombre);
        proveedor.setApellido(apellido);
        proveedor.setTelefono(telefono);
        proveedor.setMail(mail);
        String encriptada = new BCryptPasswordEncoder().encode(contrasenia);
        proveedor.setContrasenia(encriptada);
        proveedor.setEstilo(aux);
        
        
        Foto foto = fotoservicio.AgregarFoto(archivo);
        proveedor.setFotoPerfil(foto);

        proveedorrepositorio.save(proveedor);
        
        System.out.println("Proveedor");

    }

    @Transactional
    public void borrarProveedor(String id) throws errorServicios {

        Optional<Proveedor> respuesta = proveedorrepositorio.findById(id);

        if (respuesta.isPresent()) {
            proveedorrepositorio.delete(respuesta.get());

        } else {
            throw new errorServicios("No se encontro el cliente. ");
        }

    }

    @Transactional
    public void asignarTurno(String idproveedor, String idUsuario, Date fecha) throws Exception {

        Turno turno = null;

        if (idproveedor != null && !idproveedor.isEmpty() && idUsuario != null && !idUsuario.isEmpty()) {
            turno.setFecha(fecha);

        }

        if (idproveedor == null || idUsuario == null || idproveedor.isEmpty() || idUsuario.isEmpty()) {
            throw new Exception("No se encuentra el proveedor o el Usuario.");
        }
    }
    
//    @Transactional
//    public List Busquedataatuador (String estilo, String provincia){
//        return   proveedorrepositorio.busquedaProveedores(estilo, provincia);      
//    }
    
//    @Transactional
//    public List busquedaTatuador (String estilo, String provincia){
//        return proveedorrepositorio.findByEstiloAndUbicacion(estilo, provincia);
//    }

    
    /////METODO PARA CARGAR FOTOS DE Portfolios sin terminar//////
    
    
//    @Transactional
//    public void subirFoto(MultipartFile archivo, String id) throws Exception {
//
//        Proveedor proveedor = null;
//
//        if (id != null && id != "" && !id.isEmpty()) {
//            proveedor = proveedorrepositorio.getOne(id);
//         
//            
//                     
//        }
//        if (proveedor == null) {
//            throw new Exception("No se encuentra al proveedor");
//        }
//
//    }
    
    public Proveedor buscarProID (String id){
        return proveedorrepositorio.getOne(id);
    }
    
    public List <Proveedor> buscarPorIDL (String id){
        return proveedorrepositorio.buscarporId(id);
    }

    public List<Proveedor> listarProveedor() {
        return proveedorrepositorio.findAll();
    }

    public void validarDocumento(Long documento) throws errorServicios {
        if (documento == null) {
            throw new errorServicios("El documento es nulo. ");
        }
    }

    public void validarNombre(String nombre, String apellido) throws errorServicios {
        if (nombre == null || nombre.isEmpty()) {
            throw new errorServicios("El nombre es nulo o esta vacio. ");
        }
        if (apellido == null || apellido.isEmpty()) {
            throw new errorServicios("El apellido es nulo o estaa vacio. ");
        }

    }

    public void validarDomicilio(String domicilio) throws errorServicios {
        if (domicilio == null || domicilio.isEmpty()) {
            throw new errorServicios("El domicilio esta vacion o es nulo. ");
        }
    }

    public void validarTelefono(String telefono) throws errorServicios {
        if (telefono == null || telefono.isEmpty()) {
            throw new errorServicios("El telefono es vacio o es nulo. ");
        }
    }
    
    public void validarFotos (List<Foto> fotoPorfolio) throws errorServicios {
        if (fotoPorfolio == null || fotoPorfolio.isEmpty() ){
            throw new errorServicios("Seleccione al menos una imagen");
        }
    }

//    @Override
//    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
//
//    Proveedor proveedor = proveedorrepositorio.BuscarProveedorPorMail(mail);
//    
//    if(proveedor != null){
//        
//        List <GrantedAuthority> permisos = null;
//        
////        GrantedAuthority p1 = new SimpleGrantedAuthority("MODULOS_FOTOS");
////        permisos.add(p1);
////        GrantedAuthority p2 = new SimpleGrantedAuthority("MODULO_TURNO");
////        permisos.add(p2);
////        GrantedAuthority p3 = new SimpleGrantedAuthority("MODULOS_PREGRESP");
////        permisos.add(p3);
////        
//        User user = new User(proveedor.getMail(), proveedor.getContrasenia(), permisos);
//
//        return user;
//        
//    }else{
//        return null;
//    }
//    
//    }

//    @Override
//    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

 
    
    

}
