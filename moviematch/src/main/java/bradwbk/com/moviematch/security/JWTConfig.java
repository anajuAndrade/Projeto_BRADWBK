// package bradwbk.com.moviematch.security;

// import javax.crypto.SecretKey;
// import javax.crypto.spec.SecretKeySpec;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
// import org.springframework.security.oauth2.jwt.JwtDecoder;
// import org.springframework.security.oauth2.jwt.JwtEncoder;
// import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
// import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;

// import com.nimbusds.jose.jwk.source.ImmutableSecret;

// @Configuration
// public class JWTConfig {
    
//     @Value("${jwt.secret}")
//     private String secretKey;
   
//     @Bean
//     public JwtEncoder jwtEncoder(){
//         return new NimbusJwtEncoder(new ImmutableSecret<>(secretKey.getBytes()));
//     }    

//     @Bean
//     public JwtDecoder jwtDecoder(){
//         SecretKeySpec secretKeySpec = new SecretKeySpec(
//             this.secretKey.getBytes(), 
//             "HmacSHA256"
//         );

//         return NimbusJwtDecoder
//                 .withSecretKey(secretKeySpec)
//                 .macAlgorithm(MacAlgorithm.HS256)
//                 .build();
//     }
// }



