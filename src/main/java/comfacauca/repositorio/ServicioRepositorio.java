package comfacauca.repositorio;

import comfacauca.modelo.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServicioRepositorio extends JpaRepository<Servicio, Integer> {


    String querynombreservicio = "SELECT * FROM servicio\n" +
            "WHERE servicio.nombre LIKE %:searchTerm%";
    @Query(value= querynombreservicio, nativeQuery = true)
    List<Servicio> findByNombre(@Param("searchTerm")String nombre);
}
