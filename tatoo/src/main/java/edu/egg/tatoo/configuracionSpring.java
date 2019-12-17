package edu.egg.tatoo;

import edu.egg.tatoo.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


@EnableWebSecurity
@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class configuracionSpring extends WebSecurityConfigurerAdapter {

    @Autowired
    public UsuarioServicio usuarioservicio;
    
    @Autowired
    public configuracionSpring cf;
    
    
    	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(usuarioservicio).passwordEncoder(new BCryptPasswordEncoder());
	}
        
        

        
  
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/css/", "/js/", "/img/")
				.permitAll()
			.and().formLogin()
				.loginPage("/tatoo/login")
//					.loginProcessingUrl("/tatoo/actualizacion")
					.usernameParameter("username")
					.passwordParameter("password")
					.defaultSuccessUrl("tatoo/in")
					.permitAll()
				.and().logout()
					.logoutUrl("/tatoo/index")
					.logoutSuccessUrl("/login?logout")
					.permitAll()
                                        .and()
                                        .csrf().disable();
	}



//ULTIMA CONFIG
//    
//     String[] resources = new String[]{
//            "/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**"
//    };
//             
//     @Override 
//    protected void configure(HttpSecurity http) throws Exception {
//        http.headers().frameOptions().sameOrigin().and()
//                .authorizeRequests()
//                .antMatchers(resources)
//                .permitAll()
//                .and().formLogin()
//                .loginPage("/tatoo/index")
//                //                .loginProcessingUrl("")
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .defaultSuccessUrl("usuario/in")
//                                .failureUrl("/tatoo/index") 
//                .permitAll()
//                .and().logout()
//                                .logoutUrl("/tatoo/index")
//                                .logoutSuccessUrl("/tatoo/index")
//                .permitAll().and().csrf().disable();
//    }

 

//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(usuarioservicio).passwordEncoder(new BCryptPasswordEncoder());
//    }
    


   
    
//     @Override
//    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//          .withUser("user1").password(passwordEncoder().encode("user1Pass")).roles("USER")
//          .and()
//          .withUser("user2").password(passwordEncoder().encode("user2Pass")).roles("USER")
//          .and()
//          .withUser("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN");
//    }
//    
//       @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

  
    
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests()
//	        .antMatchers(resources).permitAll()  
//	        .antMatchers("/","/index").permitAll()
//	        .antMatchers("/admin*").access("hasRole('ADMIN')")
//	        .antMatchers("/user*").access("hasRole('USER')")
//                .anyRequest().authenticated()
//                .and()
//            .formLogin()
//                .loginPage("/")
//                .permitAll()
//                .defaultSuccessUrl("/in")
//                .failureUrl("/index?error=true")
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .and()
//            .logout()
//                .permitAll()
//                .logoutSuccessUrl("/login?logout");
//    }
//    
//        BCryptPasswordEncoder bCryptPasswordEncoder;
    //Crea el encriptador de contraseñas	
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//		bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
//El numero 4 representa que tan fuerte quieres la encriptacion.
//Se puede en un rango entre 4 y 31. 
//Si no pones un numero el programa utilizara uno aleatoriamente cada vez
//que inicies la aplicacion, por lo cual tus contrasenas encriptadas no funcionaran bien
//        return bCryptPasswordEncoder;
//    }
    
//    
//    @Autowired
//    UserDetailServiceImpl userDetailsService;
	
    //Registra el service para usuarios y el encriptador de contrasena
//    @Bean
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { 
// 
//     
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());     
//    }
    
  
    

    
    

 
    

    
    

//    
//    @Autowired
//	public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception{
//		builder.userDetailsService(userDetailsService).
//		passwordEncoder(passwordEncoder());
//		
//		
//		
//		
//		
//		
//		PasswordEncoder encoder = passwordEncoder();  
//		UserBuilder users= User.builder().passwordEncoder(encoder::encode);
//		
//		builder.inMemoryAuthentication()
//		
//		.withUser(users.username("ezequiel").password("12345").roles("ADMIN"));
//	}
    
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.headers().frameOptions().sameOrigin().and()
//                .authorizeRequests()
//                .antMatchers("/css/", "/js/", "/img/", "/*")
//                .permitAll()
//                .and().formLogin()
//                .loginPage("/")
//                .loginProcessingUrl("/logincheck")
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .defaultSuccessUrl("/loginsuccess")
//                .permitAll()
//                .and().logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/?logout")
//                .permitAll().and().csrf().disable();
//    }
    



}

