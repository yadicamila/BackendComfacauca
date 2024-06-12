package comfacauca.servicio.implentaciones;

import comfacauca.modelo.Venta;
import comfacauca.repositorio.VentaRepositorio;
import comfacauca.servicio.IVentaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaServicio implements IVentaServicio {

    @Autowired
    private VentaRepositorio ventaRepositorio;

    @Override
    public List<Venta> ListarVentas() {
        return ventaRepositorio.findAll();
    }
}
