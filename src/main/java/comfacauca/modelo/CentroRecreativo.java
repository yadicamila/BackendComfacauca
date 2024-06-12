package comfacauca.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CentroRecreativo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idCentro_recreativo;
    String descripcion;
    String ubicacion;
    Integer existencia;
    @OneToMany(mappedBy = "centroRecreativo")
    private List<Taquilla> taquillas;

    @OneToMany(mappedBy = "centroRecreativo")
    private List<Tarifa> tarifas;

}
