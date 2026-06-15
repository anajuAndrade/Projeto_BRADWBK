package bradwbk.com.moviematch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import bradwbk.com.moviematch.model.TipoUsuario;
import bradwbk.com.moviematch.service.TipoUsuarioService;

@RestController
@RequestMapping("/tipoUsuario")
public class TipoUsuarioController {

    @Autowired
    private TipoUsuarioService tipoUsuarioService;

    @PostMapping
    public TipoUsuario salvarTipoUsuario(@RequestBody TipoUsuario tipoUsuario) {
        return tipoUsuarioService.salvarTipoUsuario(tipoUsuario);
    }

    @GetMapping
    public Iterable<TipoUsuario> listarTipoUsuario() {
        return tipoUsuarioService.listarTipoUsuario();
    }

    @GetMapping("/{id}")
    public Optional<TipoUsuario> buscarTipoUsuarioPorId(@PathVariable Long id) {
        return tipoUsuarioService.buscarTipoUsuarioPorId(id);
    }

    @GetMapping("/nome/{nomeTipoUsuario}")
    public Optional<TipoUsuario> buscarTipoUsuarioPorNome(@PathVariable String nomeTipoUsuario) {
        return tipoUsuarioService.buscarTipoUsuarioPorNome(nomeTipoUsuario);
    }

    @PutMapping("/{id}")
    public TipoUsuario atualizarTipoUsuario(
            @PathVariable Long id,
            @RequestBody TipoUsuario tipoUsuario) {

        tipoUsuario.setId_tipoUsuario(id);

        return tipoUsuarioService.atualizarTipoUsuario(tipoUsuario);
    }

    @DeleteMapping("/{id}")
    public void deletarTipoUsuario(@PathVariable Long id) {
        tipoUsuarioService.deletarTipoUsuario(id);
    }
}
