package bradwbk.com.moviematch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import bradwbk.com.moviematch.model.Filme;
import bradwbk.com.moviematch.repository.FilmeRepository;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    
    public Filme salvarFilme(Filme filme) {
        return filmeRepository.save(filme);
    }

    public Iterable<Filme> listarFilmes() {
        return filmeRepository.findAll();
    }

    public Optional<Filme> buscarFilmePorId(Long id) {
        return filmeRepository.findById(id);
    }

    public Optional<Filme> buscarFilmePorNome(String tituloFilme) {
        return filmeRepository.findByTituloFilme(tituloFilme);
    }

    public Filme atualizarFilme(Filme filme) {
        return filmeRepository.save(filme);
    }

    public void deletarFilme(Long id) {
        filmeRepository.deleteById(id);
    }

}
