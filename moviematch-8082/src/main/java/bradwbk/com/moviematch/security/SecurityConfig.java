package bradwbk.com.moviematch.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import bradwbk.com.moviematch.security.JwtBlacklistFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	private final JWTConfig jwtConfig;
	private final JwtBlacklistFilter jwtBlacklistFilter;

	SecurityConfig(JWTConfig jwtConfig, JwtBlacklistFilter jwtBlacklistFilter) {
		this.jwtConfig = jwtConfig;
		this.jwtBlacklistFilter = jwtBlacklistFilter;
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) {
		http
				.csrf(csrf -> csrf.disable())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests((requests) -> requests
						.requestMatchers(
								"/auth/login",
								"/auth/register",
							"/auth/logout")
						.permitAll()
						.anyRequest().authenticated())
				.oauth2ResourceServer(
						oauth2 -> oauth2.jwt(jwt -> jwtConfig.jwtDecoder()))
				.addFilterBefore(jwtBlacklistFilter, UsernamePasswordAuthenticationFilter.class)
				.logout(LogoutConfigurer::permitAll);

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}