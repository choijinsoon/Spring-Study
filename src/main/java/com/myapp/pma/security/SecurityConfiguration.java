package com.myapp.pma.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

// 시큐리티 설정을 위해서는 1) WebSecurityConfigurerAdapter를 상속받아야하며 2) 어노테이션 EnableWebSecurity가 필요  
@EnableWebSecurity
@Configuration
public class SecurityConfiguration {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Bean
    public UserDetailsService userDetailsService() {
		JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
		manager.setUsersByUsernameQuery("select username, assword, enabled from user_accounts where username = ?");
		manager.setAuthoritiesByUsernameQuery("select username, role authority from user_accounts where username = ?");
		return manager;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
			.requestMatchers("/projects/**").hasAnyRole("ADMIN")
			.requestMatchers("/employees/**").hasAnyRole("ADMIN")
			.requestMatchers("/employees").authenticated()
			.requestMatchers("/projects").authenticated()
			.requestMatchers("/").permitAll()
			.and().formLogin()
			.and().exceptionHandling().accessDeniedPage("/");
		
		return http.build();
	}
}

