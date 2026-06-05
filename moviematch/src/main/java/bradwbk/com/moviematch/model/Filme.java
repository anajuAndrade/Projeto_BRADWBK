package bradwbk.com.moviematch.model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_filme;
    private String titulo_filme;
    private String descricao_filme;
    private Integer duracao_filme;
    private String streaming_filme;
    private String nacionalidade_filme;
    private String classificacao_filme;
    private String diretor_filme;
    private String atorEspecifico_filme;
    private Integer avaliacao;


    @ElementCollection
    private List<String> generos;

    @ManyToMany(mappedBy = "filmes")
    private List<Lista> listas;
}