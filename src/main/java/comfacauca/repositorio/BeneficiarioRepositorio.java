package comfacauca.repositorio;


import comfacauca.modelo.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BeneficiarioRepositorio extends JpaRepository<Beneficiario, Integer> {

    List<Beneficiario> findByAfiliado_IdAfiliado(Integer idAfiliado);
}
