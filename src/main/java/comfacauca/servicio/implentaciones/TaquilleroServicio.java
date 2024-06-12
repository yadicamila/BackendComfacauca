package comfacauca.servicio.implentaciones;

import comfacauca.modelo.Taquillero;
import comfacauca.repositorio.AfiliadoRepositorio;
import comfacauca.repositorio.TaquilleroRepositorio;
import comfacauca.servicio.ITaquilleroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class TaquilleroServicio implements ITaquilleroServicio {

    @Autowired
    private TaquilleroRepositorio TaquilleroRepositorio;

    @Override
    public List<Taquillero> ListarTaquilleros() {
        return TaquilleroRepositorio.findAll();
    }

    private static final Logger logger = LoggerFactory.getLogger(TaquilleroServicio.class);

    @Autowired
    private TaquilleroRepositorio taquilleroRepositorio;

    public Taquillero login(String usuario, String contrasena) {
        logger.info("Buscando taquillero con usuario: " + usuario);
        Taquillero taquillero = taquilleroRepositorio.findByUsuarioAndContrasena(usuario, contrasena);
        if (taquillero != null) {
            logger.info("Encontrado taquillero: " + taquillero.getIdTaquillero());
        } else {
            logger.info("No se encontró taquillero con usuario: " + usuario);
        }
        return taquillero;
    }
}
