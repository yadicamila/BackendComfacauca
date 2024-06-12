package comfacauca.controlador;

import comfacauca.excepcion.RecursoNoEncontradoExcepcion;
import comfacauca.servicio.implentaciones.CentroRecreativoServicio;
import comfacauca.modelo.CentroRecreativo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//http://locahost:8080/inventario-app
@RequestMapping("comfacauca-app")
@CrossOrigin(value = "http://localhost:4200")
public class CentroRecreativoControlador {

    private static final Logger logger =
            LoggerFactory.getLogger(CentroRecreativoControlador.class);

    @Autowired
    private CentroRecreativoServicio centroRecreativoServicio;

    //http://locahost:8080/inventario-app/centros
    @GetMapping("/centros")
    public List<CentroRecreativo> obtenercentros(){
        List<CentroRecreativo> centrorecreativos = this.centroRecreativoServicio.ListarCentros();
        logger.info("centros obtenidos:");
        centrorecreativos.forEach((centrorecreativo -> logger.info(centrorecreativo.toString())));
        return centrorecreativos;
    }

    @PostMapping("/centros")
    public CentroRecreativo agregarCentro(@RequestBody CentroRecreativo centrorecreativo){
        logger.info("centro a agregar: " + centrorecreativo);
        return this.centroRecreativoServicio.guardarCentro(centrorecreativo);
    }

    @GetMapping("/centros/{id}")
    public ResponseEntity<CentroRecreativo> obtenerCentroPorId(
            @PathVariable int id){
        CentroRecreativo centrorecreativo =
                this.centroRecreativoServicio.buscarCentrosPorId(id);
        if(centrorecreativo != null)
            return ResponseEntity.ok(centrorecreativo);
        else
            throw new RecursoNoEncontradoExcepcion("No se encontro el id: " + id);
    }

    @PutMapping("/centros/{id}")
    public ResponseEntity<CentroRecreativo> actualizarCentro(
            @PathVariable int id,
            @RequestBody CentroRecreativo centrorecreativoRecibido){
        CentroRecreativo centrorecreativo = this.centroRecreativoServicio.buscarCentrosPorId(id);
        if(centrorecreativo == null)
            throw new RecursoNoEncontradoExcepcion("No se encontro el id: " + id);
        centrorecreativo.setDescripcion(centrorecreativoRecibido.getDescripcion());
        centrorecreativo.setExistencia(centrorecreativoRecibido.getExistencia());
        centrorecreativo.setUbicacion(centrorecreativoRecibido.getUbicacion());
        this.centroRecreativoServicio.guardarCentro(centrorecreativo);
        return ResponseEntity.ok(centrorecreativo);
    }

    @DeleteMapping("/centros/{id}")
    public ResponseEntity<Map<String, Boolean>>
    eliminarCentro(@PathVariable int id){
        CentroRecreativo centrorecreativo = centroRecreativoServicio.buscarCentrosPorId(id);
        if (centrorecreativo == null)
            throw new RecursoNoEncontradoExcepcion("No se encontro el id: " + id);
        this.centroRecreativoServicio.eliminarCentroPorId(centrorecreativo.getIdCentro_recreativo());
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

}
