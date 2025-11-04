package danielavila.asignaturas.security;



import danielavila.asignaturas.entity.Usuario;
import danielavila.asignaturas.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class MiUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public MiUserDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        return User.builder()
                .username(usuario.getUsername())
                .password(usuario.getPassword())

                .roles(usuario.getRoles().stream().map(r -> r.getNombre()).toArray(String[]::new))
                .build();
    }
}
