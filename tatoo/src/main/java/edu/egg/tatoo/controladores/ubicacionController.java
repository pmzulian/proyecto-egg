package edu.egg.tatoo.controladores;

import edu.egg.tatoo.entidades.Ubicacion;
import edu.egg.tatoo.repositorios.UbicacionRepositorio;
import edu.egg.tatoo.servicios.UbicacionServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ubicacion")
public class ubicacionController {

    @Autowired
    private UbicacionServicio us;

    @Autowired
    private UbicacionRepositorio ur;

    @GetMapping("/listaubicacion")
    public void buscarporProvicia(ModelMap modelo) {

        List<Ubicacion> ubicaciones;

        ubicaciones = ur.findAll();

        modelo.put("ubicaiones", ubicaciones);

    }

}
