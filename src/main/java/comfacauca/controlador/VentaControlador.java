package comfacauca.controlador;

import comfacauca.modelo.Venta;
import comfacauca.servicio.implentaciones.VentaServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//http://locahost:8080/inventario-app
@RequestMapping("comfacauca-app")
@CrossOrigin(value = "http://localhost:4200")
public class VentaControlador {

    private static final Logger logger =
            LoggerFactory.getLogger(VentaControlador.class);

    @Autowired
    private VentaServicio ventaServicio;

    //http://locahost:8080/inventario-app/afiliados
    @GetMapping("/ventas")
    public List<Venta> obtenerventas(){
        List<Venta> ventas = this.ventaServicio.ListarVentas();
        logger.info("Ventas obtenidas:");
        ventas.forEach((venta -> logger.info(ventas.toString())));
        return ventas;
    }



}
