package com.qlas.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests().antMatchers("/login","/user").permitAll()
		.anyRequest().authenticated()
		.and().httpBasic()
		.and().formLogin();
//		.loginPage("/login").permitAll();
//			.defaultSuccessUrl("/get",true)
//			.and()
//			.logout().invalidateHttpSession(true)
//			.clearAuthentication(true)
//			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//			.logoutSuccessUrl("/logout-succes").permitAll().deleteCookies("JSESSIONID");
	}

//	@Bean
//	public RequestCache refererRequestCache() {
//		return new HttpSessionRequestCache() {
//			@Override
//			public void saveRequest(HttpServletRequest request, HttpServletResponse response) {
//				String referrer = request.getHeader("referer");
//				if (referrer != null) {
//					request.getSession().setAttribute("SPRING_SECURITY_SAVED_REQUEST",
//							new SimpleSavedRequest(referrer));
//				}
//			}
//		};
//	}

}
