package comfacauca.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.time.LocalTime;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idVenta;
    LocalTime fecha;
    Float total;
    @ManyToOne
    @JoinColumn(name = "idTaquillero")
    private Taquilla taquillero;

    @ManyToOne
    @JoinColumn(name = "afiliado_id")
    private Afiliado afiliado;

    @OneToMany(mappedBy = "venta")
    private Set<DetalleVenta> detallesVenta;

}
