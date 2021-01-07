package com.purvar.springboot.thymeleaf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration 
public class SecurityConfig extends WebSecurityConfigurerAdapter { 
	@Override 
	protected void configure(AuthenticationManagerBuilder auth) throws Exception { 
		auth.inMemoryAuthentication() 
			.withUser("javaboy").roles("admin").password("$2a$10$.A4FbN2x1BGuKl3xlys3OeGa.TeOvaQ4eWXFsLJQFjGMGYDsvc.mm") 
			.and() 
			.withUser("lisi").roles("user").password("$2a$10$M8On9ZLgIs3bx0BW./G7heFXe7QrHd5MqrL0az8B8Nt/UV1M8IQxm"); 
	} 
	
	@Bean 
	PasswordEncoder passwordEncoder() { 
		return new BCryptPasswordEncoder(); 
	} 
	
	@Override 
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/admin/*").hasRole("admin")
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/")
		.loginProcessingUrl("/login")
		.failureUrl("/loginFailure").permitAll()
		.defaultSuccessUrl("/hello").permitAll()
		.usernameParameter("loginName")
		.passwordParameter("pwd");
//		http.csrf().disable();
	}
	
	@Override 
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/about");
	}
}

