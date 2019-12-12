package edu.egg.tatoo.servicios;

import edu.egg.tatoo.entidades.Foto;
import edu.egg.tatoo.entidades.Usuario;
import edu.egg.tatoo.errores.errorServicios;
import edu.egg.tatoo.repositorios.UsuarioRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;


@Service
public class UsuarioServicio {

    @Autowired
    UsuarioRepositorio usuariorepositorio;
    @Autowired
    FotoServicio fotoservicio;
    
    


    @Transactional
    public void actualizarUsuario(MultipartFile archivo, String id, String nombre, String apellido, Long documento, Long telefono, String mail, String contrasenia) throws errorServicios, Exception {

        Usuario usuario = null;

        if (id != null && id != "" && !id.isEmpty()) {
            usuario = usuariorepositorio.getOne(id);

        }
        if (usuario == null) {
            usuario = new Usuario();
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new Exception("El nombre no puede ser nulo.");
        }

        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setDocumento(documento);
        usuario.setTelefono(telefono);
        usuario.setMail(mail);
        usuario.setContrasenia(contrasenia);
        
        Foto foto = fotoservicio.AgregarFoto(archivo);
        usuario.setFoto(foto);

        usuariorepositorio.save(usuario);

    }
    
    public Usuario buscarPorID (String id){
        return usuariorepositorio.getOne(id);
    }
    
    

    @Transactional
    public void borrarUsuario(String id) throws errorServicios {

        Optional<Usuario> respuesta = usuariorepositorio.findById(id);

        if (respuesta.isPresent()) {
            usuariorepositorio.delete(respuesta.get());

        } else {
            throw new errorServicios("No se encontro el cliente. ");
        }

    }

    public List<Usuario> listarClientes() {
        return usuariorepositorio.findAll();
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
