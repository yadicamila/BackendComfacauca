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
public class Tarifa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idTarifa;
    String categoria;
    Float descuento;
    Float tarifaFinal;

    @ManyToOne
    @JoinColumn(name = "servicio_id")
    private Servicio servicio;

    @ManyToOne
    @JoinColumn(name = "centro_recreativo_id")
    private CentroRecreativo centroRecreativo;
}
