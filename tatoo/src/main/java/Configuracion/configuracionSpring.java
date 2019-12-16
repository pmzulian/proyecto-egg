package Configuracion;

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

@Configuration
@EnableAutoConfiguration
@EnableWebSecurity

@EnableGlobalMethodSecurity(prePostEnabled = true)
public class configuracionSpring extends WebSecurityConfigurerAdapter {

    @Autowired
    public UsuarioServicio usuarioservicio;
    
    @Autowired
    public configuracionSpring cf;
    
  
    
    

 

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
       @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().sameOrigin().and()
                .authorizeRequests()
                .antMatchers("/css/", "/js/", "/img/")
                .permitAll()
                .and().formLogin()
                .loginPage("/index")
                //                .loginProcessingUrl("")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/login")
                                .failureUrl("/index") 
                .permitAll()
                .and().logout()
                                .logoutUrl("/index")
                                .logoutSuccessUrl("/index")
                .permitAll().and().csrf().disable();
    }
    

    
    

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
