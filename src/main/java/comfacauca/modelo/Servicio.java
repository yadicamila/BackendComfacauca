package comfacauca.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idServicio;
    String nombre;
    Float tarifa_plena ;

   // @OneToMany(mappedBy = "servicio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //private Set<Tarifa> tarifas;
}
