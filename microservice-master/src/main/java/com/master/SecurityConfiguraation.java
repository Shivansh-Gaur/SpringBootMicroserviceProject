package com.master;






import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;







//@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfiguraation extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth ) throws Exception{
		
		auth.inMemoryAuthentication()
		    .withUser("user")
		    .password("user")
		    .roles("USER")
		    .and()
		    .withUser("admin")
		    .password("admin")
		    .roles("ADMIN");
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		http.cors().and().csrf().disable();
		http.authorizeRequests()
		     .antMatchers("/showall").hasRole("ADMIN")
		     .antMatchers("/**").permitAll()
		     .and().formLogin();
	}
	
}
