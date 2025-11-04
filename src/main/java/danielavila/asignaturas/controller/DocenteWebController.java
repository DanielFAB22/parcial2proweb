package danielavila.asignaturas.controller;

import danielavila.asignaturas.entity.Asignatura;
import danielavila.asignaturas.repository.AsignaturaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/docente/asignaturas")
@RequiredArgsConstructor
public class DocenteWebController {

    private final AsignaturaRepository asignaturaRepository;


    @GetMapping
    public String listarAsignaturas(Model model) {
        model.addAttribute("asignaturas", asignaturaRepository.findAll());
        return "docente-asignaturas";
    }


    @GetMapping("/editar/{id}")
    public String editarHorario(@PathVariable Long id, Model model) {
        Asignatura asignatura = asignaturaRepository.findById(id).orElse(null);
        model.addAttribute("asignatura", asignatura);
        return "editar-horario";
    }


    @PostMapping("/guardarHorario")
    public String guardarHorario(@RequestParam Long id, @RequestParam String horario) {
        asignaturaRepository.findById(id).ifPresent(a -> {
            a.setHorario(horario);
            asignaturaRepository.save(a);
        });
        return "redirect:/docente/asignaturas";
    }
}
