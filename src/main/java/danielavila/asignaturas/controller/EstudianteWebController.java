package danielavila.asignaturas.controller;

import danielavila.asignaturas.repository.AsignaturaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/estudiante/asignaturas")
@RequiredArgsConstructor
public class EstudianteWebController {

    private final AsignaturaRepository asignaturaRepository;

    @GetMapping
    public String listarAsignaturas(Model model) {
        model.addAttribute("asignaturas", asignaturaRepository.findAll());
        return "estudiante-asignaturas"; // /WEB-INF/views/estudiante-asignaturas.jsp
    }
}
