package bradwbk.com.moviematch.repository;

import org.springframework.data.repository.CrudRepository;

import bradwbk.com.moviematch.model.TokenBlacklist;

public interface TokenBlacklistRepository extends CrudRepository<TokenBlacklist, Long> {

    boolean existsByToken(String token);
}