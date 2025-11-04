package danielavila.asignaturas;

import danielavila.asignaturas.entity.Rol;
import danielavila.asignaturas.entity.Usuario;
import danielavila.asignaturas.repository.RolRepository;
import danielavila.asignaturas.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private final UsuarioRepository usuarioRepo;
    private final RolRepository rolRepo;
    private final PasswordEncoder encoder;

    public DataLoader(UsuarioRepository usuarioRepo, RolRepository rolRepo, PasswordEncoder encoder) {
        this.usuarioRepo = usuarioRepo;
        this.rolRepo = rolRepo;
        this.encoder = encoder;
    }

    @Override
    public void run(String... args) throws Exception {
        Rol rector = rolRepo.findByNombre("RECTOR").orElseGet(() -> rolRepo.save(Rol.builder().nombre("RECTOR").build()));
        Rol docente = rolRepo.findByNombre("DOCENTE").orElseGet(() -> rolRepo.save(Rol.builder().nombre("DOCENTE").build()));
        Rol estudiante = rolRepo.findByNombre("ESTUDIANTE").orElseGet(() -> rolRepo.save(Rol.builder().nombre("ESTUDIANTE").build()));

        if (usuarioRepo.count() == 0) {
            usuarioRepo.save(Usuario.builder()
                    .username("rector1")
                    .password(encoder.encode("rector123"))
                    .roles(Set.of(rector))
                    .build());

            usuarioRepo.save(Usuario.builder()
                    .username("docente1")
                    .password(encoder.encode("docente123"))
                    .roles(Set.of(docente))
                    .build());

            usuarioRepo.save(Usuario.builder()
                    .username("estudiante1")
                    .password(encoder.encode("estu123"))
                    .roles(Set.of(estudiante))
                    .build());
        }


    }
}