package danielavila.asignaturas.controller;

import danielavila.asignaturas.entity.Asignatura;
import danielavila.asignaturas.repository.AsignaturaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/asignaturas")
@RequiredArgsConstructor
@SecurityRequirement(name = "basicAuth")
public class AsignaturaController {

    private final AsignaturaRepository asignaturaRepository;


    @Operation(
            summary = "Listar todas las asignaturas",
            description = "Devuelve la lista completa de asignaturas registradas en el sistema.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Listado obtenido correctamente",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Asignatura.class))
                    )
            }
    )
    @GetMapping
    public List<Asignatura> listar() {
        return asignaturaRepository.findAll();
    }


    @Operation(
            summary = "Crear una nueva asignatura",
            description = "Permite al Rector crear una nueva asignatura en el sistema.",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Asignatura creada exitosamente"),
                    @ApiResponse(responseCode = "403", description = "Acceso denegado (solo Rector)")
            }
    )
    @PreAuthorize("hasRole('RECTOR')")
    @PostMapping
    public Asignatura crear(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos de la nueva asignatura",
                    required = true,
                    content = @Content(
                            schema = @Schema(implementation = Asignatura.class),
                            examples = @ExampleObject(
                                    name = "Ejemplo de asignatura",
                                    value = """
                                            {
                                                "nombre": "Programación Web",
                                                "descripcion": "Introducción al desarrollo web con Java y Spring Boot",
                                                "salon": "302B",
                                                "horario": "Lunes y Miércoles 10:00 - 12:00",
                                                "docenteEncargado": "Juan Pérez"
                                            }
                                            """
                            )
                    )
            )
            @RequestBody Asignatura asignatura
    ) {
        return asignaturaRepository.save(asignatura);
    }


    @Operation(
            summary = "Editar una asignatura existente",
            description = "Permite al Rector modificar los datos de una asignatura por ID.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Asignatura actualizada correctamente"),
                    @ApiResponse(responseCode = "404", description = "Asignatura no encontrada")
            }
    )
    @PreAuthorize("hasRole('RECTOR')")
    @PutMapping("/{id}")
    public Asignatura editar(@PathVariable Long id, @RequestBody Asignatura datos) {
        return asignaturaRepository.findById(id)
                .map(asig -> {
                    asig.setNombre(datos.getNombre());
                    asig.setDescripcion(datos.getDescripcion());
                    asig.setSalon(datos.getSalon());
                    asig.setHorario(datos.getHorario());
                    asig.setDocenteEncargado(datos.getDocenteEncargado());
                    return asignaturaRepository.save(asig);
                })
                .orElseThrow(() -> new RuntimeException("Asignatura no encontrada"));
    }


    @Operation(
            summary = "Eliminar una asignatura",
            description = "Permite al Rector eliminar una asignatura existente.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Asignatura eliminada correctamente"),
                    @ApiResponse(responseCode = "404", description = "Asignatura no encontrada")
            }
    )
    @PreAuthorize("hasRole('RECTOR')")
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        if (asignaturaRepository.existsById(id)) {
            asignaturaRepository.deleteById(id);
            return "Asignatura eliminada correctamente.";
        }
        return "Asignatura no encontrada.";
    }


    @Operation(
            summary = "Actualizar el horario de una asignatura",
            description = "Permite al Docente asignado modificar solo el horario de su asignatura.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Horario actualizado correctamente"),
                    @ApiResponse(responseCode = "404", description = "Asignatura no encontrada")
            }
    )
    @PreAuthorize("hasRole('DOCENTE')")
    @PutMapping("/{id}/horario")
    public String actualizarHorario(
            @PathVariable Long id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Nuevo horario de la asignatura",
                    required = true,
                    content = @Content(
                            examples = @ExampleObject(
                                    name = "Ejemplo de horario",
                                    value = """
                                            {
                                                "horario": "Martes y Jueves 3:00 - 4:00"
                                            }
                                            """
                            )
                    )
            )
            @RequestBody Map<String, String> body
    ) {
        return asignaturaRepository.findById(id).map(a -> {
            a.setHorario(body.get("horario"));
            asignaturaRepository.save(a);
            return "Horario actualizado correctamente.";
        }).orElse("Asignatura no encontrada.");
    }
}
