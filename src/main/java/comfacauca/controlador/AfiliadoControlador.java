package comfacauca.controlador;

import comfacauca.excepcion.RecursoNoEncontradoExcepcion;
import comfacauca.modelo.Afiliado;
import comfacauca.modelo.CentroRecreativo;
import comfacauca.servicio.implentaciones.AfiliadoServicio;
import comfacauca.servicio.implentaciones.CentroRecreativoServicio;
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
public class AfiliadoControlador {

    private static final Logger logger =
            LoggerFactory.getLogger(AfiliadoControlador.class);

    @Autowired
    private AfiliadoServicio afiliadoServicio;

    //http://locahost:8080/inventario-app/afiliados
    @GetMapping("/afiliados")
    public List<Afiliado> obtenercentros(){
        List<Afiliado> afiliados = this.afiliadoServicio.ListarAfiliados();
        logger.info("afiliados obtenidos:");
        afiliados.forEach((afiliado -> logger.info(afiliado.toString())));
        return afiliados;
    }
    // Obtiene un afiliado por su cédula

    /*@GetMapping("/afiliados/{numerodocumento}")
    public ResponseEntity<Afiliado> obtenerAfiliadoPorNumero(@PathVariable int numerodocumento){
        Afiliado afiliado = this.AfiliadoServicio.buscarAfiliadoPorCedula(numerodocumento);
        if(afiliado != null)
            return ResponseEntity.ok(afiliado);
        else
            throw new RecursoNoEncontradoExcepcion("No se encontro la cedula: " + numerodocumento);
    }*/

    @GetMapping("/afiliados/{numerodocumento}")
    public ResponseEntity<?> obtenerAfiliadoPorNumero(@PathVariable  String numerodocumento){
        List<Afiliado> afiliados = null;
        if(numerodocumento=="")
        {
            return new ResponseEntity<List<Afiliado>>(afiliados, HttpStatus.OK);
        }else{
            afiliados = afiliadoServicio.buscarAfiliadoPorCedula(numerodocumento);
            return new ResponseEntity<List<Afiliado>>(afiliados, HttpStatus.OK);
        }
    }



}
