package bradwbk.com.moviematch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import bradwbk.com.moviematch.model.Lista;
import bradwbk.com.moviematch.service.ListaService;

@RestController
@RequestMapping("/listas")
public class ListaController {

    @Autowired
    private ListaService listaService;

    @PostMapping
    public Lista salvarLista(@RequestBody Lista lista) {
        return listaService.salvarLista(lista);
    }

    @GetMapping
    public Iterable<Lista> listarListas() {
        return listaService.listarListas();
    }

    @GetMapping("/{id}")
    public Optional<Lista> buscarListaPorId(@PathVariable Long id) {
        return listaService.buscarListaPorId(id);
    }

    @GetMapping("/nome/{nomeLista}")
    public Optional<Lista> buscarListaPorNome(@PathVariable String nomeLista) {
        return listaService.buscarListaPorNome(nomeLista);
    }

    @PutMapping("/{id}")
    public Lista atualizarLista(
            @PathVariable Long id,
            @RequestBody Lista lista) {

        lista.setId_lista(id);

        return listaService.atualizarLista(lista);
    }

    @DeleteMapping("/{id}")
    public void deletarLista(@PathVariable Long id) {
        listaService.deletarLista(id);
    }
}
