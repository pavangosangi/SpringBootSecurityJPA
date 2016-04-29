package org.book.keeper.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordencoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/Bookeeper/loginPage").permitAll()
				.antMatchers("/resources/**").permitAll()
				.antMatchers("/Bookeeper/").permitAll()
				.antMatchers("/Bookeeper/welcomeHome").access("hasRole('ROLE_ADMIN')")
				.anyRequest()
				.authenticated()
				.and()	
			.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/Bookeeper/welcomeHome")
				.failureUrl("/Bookeeper/loginPageError")
				.permitAll()
				.and()
			.logout()
				.logoutSuccessUrl("/login?logout")
				.and()
			.exceptionHandling()
				.accessDeniedPage("/Bookeeper/accessDenied")
				.and()
			.csrf();
	}

	@Bean(name = "passwordEncoder")
	public PasswordEncoder passwordencoder() {
		return new BCryptPasswordEncoder();
	}
}