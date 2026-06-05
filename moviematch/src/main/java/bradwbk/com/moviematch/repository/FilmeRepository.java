package bradwbk.com.moviematch.repository;

import org.springframework.data.repository.CrudRepository;

import bradwbk.com.moviematch.model.Filme;

public interface FilmeRepository extends CrudRepository<Filme, Long> {

}