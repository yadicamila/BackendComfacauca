package comfacauca.controlador;


import comfacauca.modelo.Taquillero;
import comfacauca.seguridad.LoginForm;
import comfacauca.seguridad.LoginResponse;
import comfacauca.servicio.implentaciones.TaquilleroServicio;
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
public class TaquilleroControlador {

    private static final Logger logger =
            LoggerFactory.getLogger(TaquilleroControlador.class);

    @Autowired
    private TaquilleroServicio TaquilleroServicio;

    //http://locahost:8080/inventario-app/taquilleros
    @GetMapping("/taquilleros")
    public List<Taquillero> obtenertaquillero(){
        List<Taquillero> taquilleros = this.TaquilleroServicio.ListarTaquilleros();
        logger.info("taquilleros obtenidos:");
        taquilleros.forEach((taquillero -> logger.info(taquillero.toString())));
        return taquilleros;
    }

    /*@PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginForm loginForm) {
        Taquillero taquillero = TaquilleroServicio.login(loginForm.getUsuario(), loginForm.getContraseña());
        if (taquillero != null) {
            return ResponseEntity.ok(new LoginResponse("Login exitoso", taquillero));
        } else {
            return ResponseEntity.status(401).body(new LoginResponse("Credenciales inválidas", null));
        }
    }*/

    @PostMapping("/login")
    public ResponseEntity<Taquillero> login(@RequestBody Taquillero taquillero) {
        logger.info("Intentando iniciar sesión con usuario: " + taquillero.getUsuario());
        Taquillero resultado = this.TaquilleroServicio.login(taquillero.getUsuario(), taquillero.getContrasena());
        if (resultado != null) {
            logger.info("Inicio de sesión exitoso para el usuario: " + taquillero.getUsuario());
            return ResponseEntity.ok(resultado);
        } else {
            logger.info("Falló el inicio de sesión para el usuario: " + taquillero.getUsuario());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
