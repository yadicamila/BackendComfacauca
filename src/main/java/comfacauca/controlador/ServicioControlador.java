package comfacauca.controlador;

import comfacauca.modelo.Servicio;
import comfacauca.servicio.implentaciones.ServicioServicio;
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
public class ServicioControlador {

    private static final Logger logger =
            LoggerFactory.getLogger(ServicioControlador.class);

    @Autowired
    private ServicioServicio ServicioServicio;

    //http://locahost:8080/inventario-app/servicios
    @GetMapping("/servicios")
    public List<Servicio> obtenercentros(){
        List<Servicio> servicios = this.ServicioServicio.ListarServicios();
        logger.info("Servicios obtenidos:");
        servicios.forEach((servicio-> logger.info(servicio.toString())));
        return servicios;
    }

    @GetMapping("/servicios/{descripcion}")
    public ResponseEntity<?> buscarServicioXNombre(@PathVariable String nombre){
        List<Servicio> Servicios = null;
        if(nombre=="")
        {
            return new ResponseEntity<List<Servicio>>(Servicios, HttpStatus.OK);
        }else{
            Servicios = ServicioServicio.obtenerServicioxNombre(nombre);
            return new ResponseEntity<List<Servicio>>(Servicios, HttpStatus.OK);
        }
    }
}
