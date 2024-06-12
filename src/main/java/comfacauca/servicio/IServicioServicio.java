package comfacauca.servicio;

import comfacauca.modelo.Servicio;

import java.util.List;

public interface IServicioServicio {

    public List<Servicio> ListarServicios();

    public List<Servicio> obtenerServicioxNombre(String descripcion);
}
