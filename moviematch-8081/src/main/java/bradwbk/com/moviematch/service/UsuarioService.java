package bradwbk.com.moviematch.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import bradwbk.com.moviematch.model.Usuario;
import bradwbk.com.moviematch.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvarUsuario(Usuario usuario) {

        usuario.setSenhaUsuario(
                passwordEncoder.encode(
                        usuario.getSenhaUsuario()));

        return usuarioRepository.save(usuario);
    }

    public Iterable<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario atualizarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

}
