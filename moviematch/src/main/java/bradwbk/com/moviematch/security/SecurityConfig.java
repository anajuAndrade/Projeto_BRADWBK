// package bradwbk.com.moviematch.security;

// public class SecurityConfig {

//     package com.example.auth.security;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {
// 	private final JwtConfig jwtConfig;

//     SecurityConfig(JwtConfig jwtConfig) {
//         this.jwtConfig = jwtConfig;
//     }

//     @Bean
// 	SecurityFilterChain securityFilterChain(HttpSecurity http) {
// 		http
// 			// Desativa CSRF para APIs
// 			.csrf(csrf -> csrf.disable()) 
//         	// APIs Restful não possuem sessão, logo estamos desativando aqui
// 			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
// 			.authorizeHttpRequests((requests) -> 
//                 requests
// 						// Essas rotas podem ser acessadas livremente
// 						.requestMatchers("/auth/login").permitAll()
// 						// Todas as outras precisam de autenticação 
//                         .anyRequest().authenticated()
// 			)
// 			// Configura para utilizar o jwtDecoder para validar o Token
// 			.oauth2ResourceServer(
// 				oauth2 -> oauth2.jwt(jwt -> jwtConfig.jwtDecoder())
// 			)
// 			.logout(LogoutConfigurer::permitAll);

// 		return http.build();
// 	}

// 	@Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
// }

// }


