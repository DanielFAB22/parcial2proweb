package danielavila.asignaturas.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String redirigirPorRol(Authentication auth) {
        if (auth != null && auth.isAuthenticated()) {
            if (auth.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_RECTOR"))) {
                return "redirect:/rector/asignaturas";
            } else if (auth.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_DOCENTE"))) {
                return "redirect:/docente/asignaturas";
            } else if (auth.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_ESTUDIANTE"))) {
                return "redirect:/estudiante/asignaturas";
            }
        }

        return "login";
    }
}
