package com.example.week7_challenge.securities;


import com.example.week7_challenge.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private SSUserDetailsService userDetailsService;

	@Autowired
	private UserRepository userRepository;

	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http
				.authorizeRequests()
				.antMatchers("/","/index","/login","/h2-console/**","/register","/user","/jobseekerform","/jobseekerlist").permitAll()
				.antMatchers("/jobseekerlist", "/user").access("hasAuthority('ADMIN')")
				.anyRequest().authenticated()
				.and()
				.formLogin().loginPage("/login").permitAll()
				.and()
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login").permitAll().permitAll();
				http.csrf().disable();
				http.headers().frameOptions().disable();

	}

	protected void configure (AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().withUser("employer").password("pass").authorities("ADMIN");
		auth.inMemoryAuthentication().withUser("jobseeker").password("pass").authorities("USER");
		auth.userDetailsService(userDetailsServiceBean());
	}
}