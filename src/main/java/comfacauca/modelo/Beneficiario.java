package comfacauca.modelo;

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
public class Beneficiario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idBeneficiario;
    String tipodocumento;
    Integer numerodocumento;
    String nombre;
    String apellido;
    String parentezco;

    @ManyToOne
    @JoinColumn(name = "id_afiliado")
    private Afiliado afiliado;

}
