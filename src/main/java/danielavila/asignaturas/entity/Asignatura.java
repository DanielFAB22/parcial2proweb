package danielavila.asignaturas.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "asignatura")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private String salon;
    private String horario;
    private String docenteEncargado;
}
