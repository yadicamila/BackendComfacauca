package comfacauca.repositorio;

import comfacauca.modelo.Taquillero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaquilleroRepositorio extends JpaRepository<Taquillero, Integer> {

    Taquillero findByUsuarioAndContrasena(String usuario, String contrasena);
}
