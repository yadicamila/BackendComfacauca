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
public class Taquilla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idTaquilla;
    String descripcion;
    Integer existencia;

    @ManyToOne
    @JoinColumn(name = "centro_recreativo_id")
    private CentroRecreativo centroRecreativo;

    @OneToMany(mappedBy = "taquilla", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Taquillero> taquilleros;


}
