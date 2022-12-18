package com.myapp.pma.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@EnableWebSecurity
//@Configuration
public class securityConfiguration{
//public class securityConfiguration extends WebSecurityConfiguration{

//	public void configure(AuthenticationManagerBuilder auth) throws Exception{
//		auth.inMemoryAuthentication()
//		.withUser("user").password(getPasswordEncoder().encode("user")).roles("USER")
//		.and()
//		.withUser("admin").password(getPasswordEncoder().encode("admin")).roles("ADMIN");
//	}
//	
//	@Bean
//	public PasswordEncoder getPasswordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}
//	
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests()
//		.requestMatchers("/projects/new").hasRole("ADMIN")		// 관리자의 허용범위 지정(새 프로젝트, 새 직원 추가 가능)
//		.requestMatchers("/projects/save").hasRole("ADMIN")
//		.requestMatchers("/employees/new").hasRole("ADMIN") 
//		.requestMatchers("/employees/save").hasRole("ADMIN")
//		.requestMatchers("/employees").authenticated()			// 인증된 유저(로그인 한 모든 유저)에게만 허용
//		.requestMatchers("/projects").authenticated()
//		.requestMatchers("/").permitAll()						// 그 외 페이지는 인증과 관계없이 모두에게 열람허용
//		.and().formLogin()
//		.and().exceptionHandling().accessDeniedPage("/"); //예외 발생시 기본페이지로	
//
//	}
}
