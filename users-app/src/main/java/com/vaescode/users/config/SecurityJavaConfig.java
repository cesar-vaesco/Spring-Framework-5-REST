/**
 * 
 */
package com.vaescode.users.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * @author thece
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityJavaConfig extends WebSecurityConfigurerAdapter {

	/* Definir usuario y contraseña */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password(encoder().encode("vaesco")).roles("ADMIN")
		.and().withUser("user").password(encoder().encode("vaesco")).roles("USER");
	}

	/* Definir los permisos para revisar las endpoint de los recursos */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		.antMatchers("**/users/**").hasRole("USER")
		.antMatchers("/roles").hasRole("ADMIN").anyRequest().authenticated().and().httpBasic();
		//.antMatchers("/rol").permitAll().anyRequest().authenticated().and().httpBasic();
	}

	/* Codificar la contraseña */
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

}
