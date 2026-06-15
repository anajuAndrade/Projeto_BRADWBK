package bradwbk.com.moviematch.service;

import java.time.Instant;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import bradwbk.com.moviematch.security.JWTConfig;

@Service
public class JwtService {
    @Autowired
    private JWTConfig jwtConfig;
    
    final private long expiringSecs = 3600; // 1 hora


    private JwtClaimsSet configJwtClaim(Instant time, long expiringSecs, String username) {
        // Configura as informações (Claims) do payload do token
        return JwtClaimsSet.builder()
                .issuer("moviematch")
                .issuedAt(time)
                .expiresAt(time.plusSeconds(expiringSecs))
                .subject(username)
                // .claim("roles", listaDeRoles) // Você pode adicionar claims customizados aqui
                .build();
    }

    public String generateToken(String username) {
        Instant now = Instant.now();

        JwtClaimsSet claims = this.configJwtClaim(now, expiringSecs, username);
        JwsHeader header = JwsHeader.with(MacAlgorithm.HS256).build();
        JwtEncoder enconder = jwtConfig.jwtEncoder();
        return enconder.encode(JwtEncoderParameters.from(header, claims)).getTokenValue();
    }

    public LocalDateTime getExpiringSecs() {
        return LocalDateTime.now().plusSeconds(expiringSecs);
    }
}
