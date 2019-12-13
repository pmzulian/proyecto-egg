package edu.egg.tatoo;

import edu.egg.tatoo.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class TatooApplication extends WebSecurityConfigurerAdapter    {
//  extends WebSecurityConfigurerAdapter  
    
    @Autowired
    private UsuarioServicio usuarioservicio;

	public static void main(String[] args)  {
		SpringApplication.run(TatooApplication.class, args);
	}
       
        
       
        public void configureGlobal (AuthenticationManagerBuilder auth) throws Exception{
            auth.userDetailsService(usuarioservicio).passwordEncoder(new BCryptPasswordEncoder() );
        }
     
        
  @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().sameOrigin().and()
                .authorizeRequests()
                .antMatchers("/css/", "/js/", "/img/")
                .permitAll()
                .and().formLogin()
                .loginPage("/")
                .loginProcessingUrl("/logincheck")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/loginsuccess")
                .permitAll()
                .and().logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/?logout")
                .permitAll().and().csrf().disable();
}
        

}
