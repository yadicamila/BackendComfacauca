package comfacauca.controlador;

import comfacauca.modelo.DetalleVenta;
import comfacauca.modelo.Venta;
import comfacauca.servicio.implentaciones.DetalleVentaServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//http://locahost:8080/inventario-app
@RequestMapping("comfacauca-app")
@CrossOrigin(value = "http://localhost:4200")
public class DetalleVentaControlador {

    private static final Logger logger =
            LoggerFactory.getLogger(DetalleVentaControlador.class);

    @Autowired
    private DetalleVentaServicio detalleVentaServicio;

    //http://locahost:8080/inventario-app/afiliados
    @GetMapping("/detalle-ventas")
    public List<DetalleVenta> obtenerDetalleventas(){
        List<DetalleVenta> detalleVentas = this.detalleVentaServicio.ListarDetalleVentas();
        logger.info("Detalle de venta:");
        detalleVentas.forEach((detalleVenta-> logger.info(detalleVentas.toString())));
        return detalleVentas;
    }



}
