package bradwbk.com.moviematch.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bradwbk.com.moviematch.model.Lista;
import bradwbk.com.moviematch.repository.ListaRepository;

@Service
public class ListaService {

    @Autowired
    private ListaRepository listaRepository;

    
    public Lista salvarLista(Lista lista) {
        return listaRepository.save(lista);
    }

    public Iterable<Lista> listarListas() {
        return listaRepository.findAll();
    }

    public Optional<Lista> buscarListaPorId(Long id) {
        return listaRepository.findById(id);
    }

    public Optional<Lista> buscarListaPorNome(String nomeLista) {
        return listaRepository.findByNomeLista(nomeLista);
    }

    public Lista atualizarLista(Lista lista) {
        return listaRepository.save(lista);
    }

    public void deletarLista(Long id) {
        listaRepository.deleteById(id);
    }
  
}
