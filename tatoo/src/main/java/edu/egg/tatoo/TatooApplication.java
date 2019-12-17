    package edu.egg.tatoo;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@SpringBootApplication 
public class TatooApplication extends WebSecurityConfigurerAdapter    {
    
   
    
//    @Autowired
//    private configuracionSpring cs;

	public static void main(String[] args)  {
	 SpringApplication.run(TatooApplication.class, args);
                
                
	}
        
        

       
        

}
