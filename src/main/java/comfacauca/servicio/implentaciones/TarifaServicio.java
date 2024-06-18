package comfacauca.servicio.implentaciones;

import comfacauca.modelo.Tarifa;
import comfacauca.repositorio.TarifaRepositorio;
import comfacauca.servicio.ITarifaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarifaServicio implements ITarifaServicio {

    @Autowired
    private TarifaRepositorio TarifaRepositorio;

    @Override
    public List<Tarifa> ListarTarifas() {
        return TarifaRepositorio.findAll();
    }

}
