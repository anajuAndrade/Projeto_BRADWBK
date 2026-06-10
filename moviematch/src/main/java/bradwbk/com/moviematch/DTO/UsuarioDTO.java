package bradwbk.com.moviematch.DTO;

import bradwbk.com.moviematch.model.Usuario;

public record UsuarioDTO(
    Long id_usuario,
    String nome_usuario,
    String email_usuario
) {

    public static UsuarioDTO fromUsuario(Usuario usuario){
        return new UsuarioDTO(
            usuario.getId_usuario(),
            usuario.getNome_usuario(),
            usuario.getEmailUsuario()
        );
    }
}
