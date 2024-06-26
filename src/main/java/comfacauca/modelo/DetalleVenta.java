package comfacauca.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idDetalleVenta;
    float cantidad;
    float subtotal;

    //asi esta originalmente

    @ManyToOne
    @JoinColumn(name = "venta_id")
    private Venta venta;


    //@OneToMany(mappedBy = "detalleVenta")
    //private Set<Venta> venta;

    @ManyToOne
    @JoinColumn(name = "servicio_id")
    private Servicio servicio;

}
