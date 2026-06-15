package bradwbk.com.moviematch.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bradwbk.com.moviematch.model.TokenBlacklist;
import bradwbk.com.moviematch.repository.TokenBlacklistRepository;

@Service
public class TokenBlacklistService {

    @Autowired
    private TokenBlacklistRepository repository;

    public void blacklistToken(String token) {

        if (!repository.existsByToken(token)) {

            TokenBlacklist blacklist = new TokenBlacklist();

            blacklist.setToken(token);
            blacklist.setDataRevogacao(LocalDateTime.now());

            repository.save(blacklist);
        }
    }

    public boolean isBlacklisted(String token) {
        return repository.existsByToken(token);
    }
}