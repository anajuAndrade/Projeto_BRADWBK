package bradwbk.com.moviematch.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;
    private String nome_usuario;
    private String email_usuario;
    private String nomeDeUsuario_usuario;
    private String senha_usuario;
    private LocalDate dataNascimento_usuario;

    @ManyToOne
    @JoinColumn(name = "id_tipoUsuario")
    private TipoUsuario tipoUsuario;

    @OneToMany(mappedBy = "usuario")
    private List<Lista> listas;

}