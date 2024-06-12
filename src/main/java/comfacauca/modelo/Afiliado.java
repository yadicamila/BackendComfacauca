package comfacauca.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.util.List;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Afiliado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idAfiliado;
    String nombre;
    String apellido;
    String tipodocumento;
    String numerodocumento;
    Character categoria;

    @OneToMany(mappedBy = "afiliado")
    private Set<Beneficiario> Beneficiario;

    @OneToMany(mappedBy = "afiliado")
    private List<Venta> ventas;
}
