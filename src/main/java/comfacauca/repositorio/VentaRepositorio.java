package comfacauca.repositorio;

import comfacauca.modelo.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VentaRepositorio extends JpaRepository<Venta, Integer> {

}
