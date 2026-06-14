package bradwbk.com.moviematch.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import bradwbk.com.moviematch.DTO.AuthDTO;
import bradwbk.com.moviematch.DTO.LoginDTO;
import bradwbk.com.moviematch.DTO.UsuarioDTO;
import bradwbk.com.moviematch.model.Usuario;
import bradwbk.com.moviematch.repository.UsuarioRepository;
import bradwbk.com.moviematch.service.JwtService;
import bradwbk.com.moviematch.service.UsuarioService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<AuthDTO> login(
            @RequestBody LoginDTO loginDTO) {

        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmailUsuario(
                loginDTO.emailUsuario());

        if (usuarioOpt.isEmpty()) {
            return ResponseEntity.status(401).build();
        }

        Usuario usuario = usuarioOpt.get();

        boolean senhaValida = passwordEncoder.matches(
                loginDTO.senhaUsuario(),
                usuario.getSenhaUsuario());

        if (!senhaValida) {
            return ResponseEntity.status(401).build();
        }

        String token = jwtService.generateToken(
                usuario.getEmailUsuario());

        return ResponseEntity.ok(
                new AuthDTO(
                        token,
                        jwtService.getExpiringSecs()));
    }

    @GetMapping("/secured/{userId}")
    public ResponseEntity<UsuarioDTO> getSecured(
            @PathVariable Long userId) {

        Usuario usuario = usuarioRepository.findById(userId).orElseThrow();

        return ResponseEntity.ok(
                UsuarioDTO.fromUsuario(usuario));
    }

    @PostMapping("/register")
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.salvarUsuario(usuario);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        return ResponseEntity.ok("Logout realizado com sucesso");
    }
    
    
}