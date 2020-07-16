	package com.Alex.Security;
	
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

	// Definite valid users
	@Configuration
	@EnableWebSecurity
	public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
		
		@Autowired
		public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
				throws Exception {
			// Valid users and specific role for each
			auth.inMemoryAuthentication().withUser("Alex").password(passwordEncoder().encode("github"))
					.roles("USER", "ADMIN");
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			// login extension does not require any role
			http.authorizeRequests().antMatchers("/login").permitAll()
			// Any url that contains the extension todo is secured
			// To access the urls, session has to have the user role
					.antMatchers("/**").access("hasRole('USER')").and()
					.formLogin();
		}

		@Bean
		public PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}
	}
