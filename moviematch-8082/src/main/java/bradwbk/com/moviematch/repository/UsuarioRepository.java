package bradwbk.com.moviematch.repository;

import org.springframework.data.repository.CrudRepository;
import bradwbk.com.moviematch.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    Optional<Usuario> findByEmailUsuario(String emailUsuario);

}
