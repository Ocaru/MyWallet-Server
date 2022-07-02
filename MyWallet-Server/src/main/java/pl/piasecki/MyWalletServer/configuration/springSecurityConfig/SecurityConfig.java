package pl.piasecki.MyWalletServer.configuration.springSecurityConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import pl.piasecki.MyWalletServer.service.CustomUserDetailsService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final ObjectMapper objectMapper;
	private final RestAuthenticationSuccessHandler successHandler;
	private final RestAuthenticationFailureHandler failureHandler;
	private final CustomUserDetailsService userDetailsService;
	private final String secret;

	public SecurityConfig(ObjectMapper objectMapper, RestAuthenticationSuccessHandler successHandler,
			RestAuthenticationFailureHandler failureHandler, CustomUserDetailsService userDetailsService,
			@Value("${jwt.secret}") String secret) {
		this.objectMapper = objectMapper;
		this.successHandler = successHandler;
		this.failureHandler = failureHandler;
		this.userDetailsService = userDetailsService;
		this.secret = secret;
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable();
		http.authorizeRequests()
			.antMatchers("/login**").permitAll()
			.antMatchers("/**").hasAuthority("ROLE_ADMIN")
			.antMatchers("/**").hasAuthority("ROLE_USER")
			.antMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.addFilter(authenticationFilter())
			.addFilter(new JwtAuthorizationFilter(authenticationManager(), userDetailsService(), secret))
			.exceptionHandling().authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));
	}

	public JsonObjectAuthenticationFilter authenticationFilter() throws Exception {
		JsonObjectAuthenticationFilter authenticationFilter = new JsonObjectAuthenticationFilter(objectMapper);
		authenticationFilter.setAuthenticationSuccessHandler(successHandler);
		authenticationFilter.setAuthenticationFailureHandler(failureHandler);
		authenticationFilter.setAuthenticationManager(super.authenticationManager());
		return authenticationFilter;
	}

}
