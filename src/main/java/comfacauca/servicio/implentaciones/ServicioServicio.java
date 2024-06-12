package comfacauca.servicio.implentaciones;

import comfacauca.modelo.Servicio;
import comfacauca.repositorio.ServicioRepositorio;
import comfacauca.servicio.IServicioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioServicio implements IServicioServicio {

    @Autowired
    private ServicioRepositorio ServicioRepositorio;

    @Override
    public List<Servicio> ListarServicios() {
        return ServicioRepositorio.findAll();
    }

    @Override
    public List<Servicio> obtenerServicioxNombre(String nombre) {
        return ServicioRepositorio.findByNombre(nombre);
    }
}
