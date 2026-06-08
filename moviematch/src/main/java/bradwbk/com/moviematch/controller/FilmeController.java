package bradwbk.com.moviematch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import bradwbk.com.moviematch.model.Filme;
import bradwbk.com.moviematch.service.FilmeService;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @PostMapping
    public Filme salvarFilme(@RequestBody Filme filme) {
        return filmeService.salvarFilme(filme);
    }

    @GetMapping
    public Iterable<Filme> listarFilmes() {
        return filmeService.listarFilmes();
    }

    @GetMapping("/{id}")
    public Optional<Filme> buscarFilmePorId(@PathVariable Long id) {
        return filmeService.buscarFilmePorId(id);
    }

    @GetMapping("/titulo/{tituloFilme}")
    public Optional<Filme> buscarFilmePorNome(@PathVariable String tituloFilme) {
        return filmeService.buscarFilmePorNome(tituloFilme);
    }

    @PutMapping("/{id}")
    public Filme atualizarFilme(
            @PathVariable Long id,
            @RequestBody Filme filme) {

        filme.setId_filme(id);

        return filmeService.atualizarFilme(filme);
    }

    @DeleteMapping("/{id}")
    public void deletarFilme(@PathVariable Long id) {
        filmeService.deletarFilme(id);
    }

}