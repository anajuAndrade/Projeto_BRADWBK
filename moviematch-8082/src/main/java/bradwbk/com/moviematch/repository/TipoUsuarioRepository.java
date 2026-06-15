package bradwbk.com.moviematch.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

import bradwbk.com.moviematch.model.TipoUsuario;

public interface TipoUsuarioRepository extends CrudRepository<TipoUsuario, Long> {
    Optional<TipoUsuario> findByNomeTipoUsuario(String nomeTipoUsuario);
}
