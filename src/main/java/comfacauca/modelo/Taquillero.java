package comfacauca.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Taquillero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idTaquillero;
    String  tipoDocumento;
    Integer numerodocumento;
    String nombre;
    String apellido;
    String usuario;
    String contrasena;

    @ManyToOne
    @JoinColumn(name = "taquilla_id")
    @JsonIgnore
    private Taquilla taquilla;
}
