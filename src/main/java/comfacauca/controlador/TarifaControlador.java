package comfacauca.controlador;

import comfacauca.modelo.Tarifa;
import comfacauca.servicio.implentaciones.TarifaServicio;
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
public class TarifaControlador {

    private static final Logger logger =
            LoggerFactory.getLogger(TarifaControlador.class);

    @Autowired
    private TarifaServicio tarifaServicio;

    //http://locahost:8080/inventario-app/afiliados
    @GetMapping("/tarifas")
    public List<Tarifa> obtenerTarifas(){
        List<Tarifa> tarifas = this.tarifaServicio.ListarTarifas();
        logger.info("Tarifas:");
        tarifas.forEach((tarifa-> logger.info(tarifas.toString())));
        return tarifas;
    }



}
