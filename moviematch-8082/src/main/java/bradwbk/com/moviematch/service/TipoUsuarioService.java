package bradwbk.com.moviematch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import bradwbk.com.moviematch.model.TipoUsuario;
import bradwbk.com.moviematch.repository.TipoUsuarioRepository;

@Service
public class TipoUsuarioService {
        @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    
    public TipoUsuario salvarTipoUsuario(TipoUsuario tipoUsuario) {
        return tipoUsuarioRepository.save(tipoUsuario);
    }

    public Iterable<TipoUsuario> listarTipoUsuario() {
        return tipoUsuarioRepository.findAll();
    }

    public Optional<TipoUsuario> buscarTipoUsuarioPorId(Long id) {
        return tipoUsuarioRepository.findById(id);
    }

    public Optional<TipoUsuario> buscarTipoUsuarioPorNome(String nomeTipoUsuario) {
        return tipoUsuarioRepository.findByNomeTipoUsuario(nomeTipoUsuario);
    }

    public TipoUsuario atualizarTipoUsuario(TipoUsuario tipoUsuario) {
        return tipoUsuarioRepository.save(tipoUsuario);
    }

    public void deletarTipoUsuario(Long id) {
        tipoUsuarioRepository.deleteById(id);
    }
}
