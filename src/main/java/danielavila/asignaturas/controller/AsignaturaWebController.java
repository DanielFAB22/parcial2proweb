package danielavila.asignaturas.controller;

import danielavila.asignaturas.entity.Asignatura;
import danielavila.asignaturas.repository.AsignaturaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rector/asignaturas")
@RequiredArgsConstructor
public class AsignaturaWebController {

    private final AsignaturaRepository asignaturaRepository;


    @GetMapping
    public String listarAsignaturas(Model model) {
        model.addAttribute("asignaturas", asignaturaRepository.findAll());
        return "rector-asignaturas";
    }


    @GetMapping("/nueva")
    public String nuevaAsignatura(Model model) {
        model.addAttribute("asignatura", new Asignatura());
        return "form-asignatura";
    }


    @PostMapping("/guardar")
    public String guardarAsignatura(@ModelAttribute Asignatura asignatura) {
        asignaturaRepository.save(asignatura);
        return "redirect:/rector/asignaturas";
    }


    @GetMapping("/editar/{id}")
    public String editarAsignatura(@PathVariable Long id, Model model) {
        model.addAttribute("asignatura", asignaturaRepository.findById(id).orElse(new Asignatura()));
        return "form-asignatura";
    }


    @GetMapping("/eliminar/{id}")
    public String eliminarAsignatura(@PathVariable Long id) {
        asignaturaRepository.deleteById(id);
        return "redirect:/rector/asignaturas";
    }
}
