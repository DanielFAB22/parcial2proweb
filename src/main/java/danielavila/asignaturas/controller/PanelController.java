package danielavila.asignaturas.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Tag(name = "Paneles de usuario", description = "Endpoints que representan los paneles de acceso para cada rol del sistema")
public class PanelController {

    @Operation(
            summary = "Panel del Rector",
            description = "Devuelve el contenido del panel exclusivo del Rector. "
                    + "Accesible solo para usuarios con el rol RECTOR."
    )
    @GetMapping("/rector/panel")
    public String rectorPanel() {
        return "Panel del RECTOR";
    }

    @Operation(
            summary = "Panel del Docente",
            description = "Devuelve el contenido del panel exclusivo del Docente. "
                    + "Accesible solo para usuarios con el rol DOCENTE."
    )
    @GetMapping("/docente/panel")
    public String docentePanel() {
        return "Panel del DOCENTE";
    }

    @Operation(
            summary = "Panel del Estudiante",
            description = "Devuelve el contenido del panel exclusivo del Estudiante. "
                    + "Accesible solo para usuarios con el rol ESTUDIANTE."
    )
    @GetMapping("/estudiante/panel")
    public String estudiantePanel() {
        return "Panel del ESTUDIANTE";
    }

    @Operation(
            summary = "Ruta pública",
            description = "Devuelve un mensaje de ejemplo para una ruta pública. "
                    + "Puede requerir login dependiendo de la configuración de seguridad."
    )
    @GetMapping("/publico")
    public String publico() {
        return "Ruta pública (requiere login para la app por la configuración).";
    }
}
