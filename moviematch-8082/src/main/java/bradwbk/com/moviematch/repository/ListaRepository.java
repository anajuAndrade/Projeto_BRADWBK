package bradwbk.com.moviematch.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import bradwbk.com.moviematch.model.Lista;

public interface ListaRepository extends CrudRepository<Lista, Long> {
    Optional<Lista> findByNomeLista(String nomeLista);
}
