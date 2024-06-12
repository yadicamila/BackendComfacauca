package comfacauca.controlador;

import comfacauca.modelo.Afiliado;
import comfacauca.modelo.Beneficiario;
import comfacauca.servicio.implentaciones.BeneficiarioServicio;
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
public class BeneficiarioControlador {

    private static final Logger logger =
            LoggerFactory.getLogger(BeneficiarioControlador.class);

    @Autowired
    private BeneficiarioServicio beneficiarioServicio;

    //http://locahost:8080/inventario-app/afiliados
    @GetMapping("/beneficiarios")
    public List<Beneficiario> obtenerbeneficiarios(){
        List<Beneficiario> beneficiarios = beneficiarioServicio.ListarBeneficiarios();
        logger.info("Beneficiarios obtenidos:");
        beneficiarios.forEach((beneficiario-> logger.info(beneficiario.toString())));
        return beneficiarios;
    }

    @GetMapping("/beneficiarios/{idafiliado}")
    public ResponseEntity<?> obtenerAfiliadoPorNumero(@PathVariable  Integer idafiliado){
        List<Beneficiario> beneficiarios = null;
        if(idafiliado==0)
        {
            return new ResponseEntity<List<Beneficiario>>(beneficiarios, HttpStatus.OK);
        }else{
            beneficiarios = beneficiarioServicio.obtenerBeneficiariosPorIdAfiliado(idafiliado);
            return new ResponseEntity<List<Beneficiario>>(beneficiarios, HttpStatus.OK);
        }
    }

}
