package comfacauca.repositorio;

import comfacauca.modelo.Afiliado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AfiliadoRepositorio extends JpaRepository<Afiliado, Integer> {

    List<Afiliado> findByNumerodocumento(String numerodocumento);
}
