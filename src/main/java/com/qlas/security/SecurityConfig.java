package com.qlas.security;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.session.SessionManagementFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private RestAuthEntryPoint restAuthEntryPoint;

	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		//provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;
	}
	
	@Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowedOrigins(Collections.singletonList("http://localhost:3000"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST", "OPTIONS"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return  source;
    }
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.cors(withDefaults())
		.and()
				.exceptionHandling()
				.authenticationEntryPoint(restAuthEntryPoint)
			.and()
				.authorizeRequests()
				.antMatchers(HttpMethod.GET,"/user").permitAll()
				.anyRequest().authenticated()
			.and()
				.formLogin()
				.loginProcessingUrl("/performLogin")
			
			.and()
				.csrf().disable();
		
		
		//.and().formLogin();
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
