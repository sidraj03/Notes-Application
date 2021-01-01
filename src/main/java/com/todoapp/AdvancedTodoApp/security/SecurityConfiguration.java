package com.todoapp.AdvancedTodoApp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
  
	@Autowired
	UserDetailsService userDetailsService;
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService);
//	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(daoAuthenticationProvider());
	}
	
	@Bean
	public AuthenticationProvider daoAuthenticationProvider() {
	    DaoAuthenticationProvider provider = 
	      new DaoAuthenticationProvider();
	   
	    provider.setPasswordEncoder(passwordEncoder());
	    provider.setUserDetailsService(userDetailsService);
	    
	    return provider;
	  }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		
		http
		.authorizeRequests()
		 .antMatchers("/register").anonymous()
		 .antMatchers("/saveUser").anonymous()
		 .anyRequest()
		 .authenticated()
		 .and()
		 .formLogin()
		  .loginPage("/login")
		  .defaultSuccessUrl("/list", true)
		  .permitAll()
		 .and()
		  .logout()
	       .logoutRequestMatcher(new AntPathRequestMatcher("/login?logout"))
//		  .logoutUrl("/logout")
//		  .logoutSuccessUrl("/login?logout")
		  .invalidateHttpSession(true)
		  .deleteCookies("JSESSIONID");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();	
	} 
	
}
