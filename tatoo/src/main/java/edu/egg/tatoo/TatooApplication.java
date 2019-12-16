    package edu.egg.tatoo;

import Configuracion.configuracionSpring;
import edu.egg.tatoo.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@SpringBootApplication
public class TatooApplication extends WebSecurityConfigurerAdapter    {
    
    @Autowired
    private UsuarioServicio usuarioservicio;
    
    @Autowired
    private configuracionSpring cs;

	public static void main(String[] args)  {
	 SpringApplication.run(TatooApplication.class, args);
                
                
	}
        
        

       
        

}
