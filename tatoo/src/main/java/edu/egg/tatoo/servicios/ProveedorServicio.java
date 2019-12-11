package edu.egg.tatoo.servicios;

import edu.egg.tatoo.entidades.Foto;
import edu.egg.tatoo.entidades.Proveedor;
import edu.egg.tatoo.entidades.Turno;
import edu.egg.tatoo.entidades.Usuario;
import edu.egg.tatoo.errores.errorServicios;
import edu.egg.tatoo.repositorios.ProveedorRepositorio;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

public class ProveedorServicio {

    @Autowired
    private ProveedorRepositorio proveedorrepositorio;

    @Autowired
    private FotoServicio fotoservicio;
    
    @Transactional
    public void actualizarProveedor(MultipartFile archivo, String id, Long documento, String nombre, String apellido, String domicilio, String telefono) throws errorServicios, Exception {

        Proveedor proveedor = null;

        if (id != null && id != "" && !id.isEmpty()) {
            proveedor = proveedorrepositorio.getOne(id);

        }
        if (proveedor == null) {
            proveedor = new Proveedor();
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new Exception("El nombre no puede ser nulo.");
        }

        proveedor.setAocumento(documento);
        proveedor.setNombre(nombre);
        proveedor.setApellido(apellido);
        proveedor.setContrasenia(nombre);
        proveedor.setMail(id);
        proveedor.setTelefono(documento);

        Foto foto = fotoservicio.AgregarFoto(archivo);
        proveedor.setFoto((List<Foto>) foto);

        proveedorrepositorio.save(proveedor);

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
    public void asignarTurno (String idproveedor, String idUsuario, Date fecha) throws Exception{
        
        Turno turno = null;
        
       if (idproveedor != null && !idproveedor.isEmpty() && idUsuario != null && !idUsuario.isEmpty()) {
            turno.setFecha(fecha);

        }

        if (idproveedor == null || idUsuario == null || idproveedor.isEmpty() || idUsuario.isEmpty()) {
            throw new Exception("No se encuentra el proveedor o el Usuario.");
        }
        
        
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
    
    

}
