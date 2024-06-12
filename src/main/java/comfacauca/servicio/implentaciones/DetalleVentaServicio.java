package comfacauca.servicio.implentaciones;

import comfacauca.modelo.DetalleVenta;
import comfacauca.repositorio.DetalleVentaRepositorio;
import comfacauca.servicio.IDetalleVentaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleVentaServicio implements IDetalleVentaServicio {

    @Autowired
    private DetalleVentaRepositorio detalleVentaRepositorio;

    @Override
    public List<DetalleVenta> ListarDetalleVentas() {
        return this.detalleVentaRepositorio.findAll();
    }

}
