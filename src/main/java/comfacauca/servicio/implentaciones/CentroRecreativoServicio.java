package comfacauca.servicio.implentaciones;

import comfacauca.modelo.CentroRecreativo;
import comfacauca.repositorio.CentroRecreativoRepositorio;
import comfacauca.servicio.ICentroRecreativoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CentroRecreativoServicio implements ICentroRecreativoServicio {

    @Autowired
    private CentroRecreativoRepositorio centroRecreativoRepositorio;

    @Override
    public List<CentroRecreativo> ListarCentros() {
        return this.centroRecreativoRepositorio.findAll();
    }

    @Override
    public CentroRecreativo buscarCentrosPorId(Integer idProducto) {
        CentroRecreativo centrorecreativo =
                this.centroRecreativoRepositorio.findById(idProducto).orElse(null);
        return centrorecreativo;
    }

    @Override
    public CentroRecreativo guardarCentro(CentroRecreativo centrorecreativo) {
        return this.centroRecreativoRepositorio.save(centrorecreativo);
    }

    @Override
    public void eliminarCentroPorId(Integer idProducto) {
        this.centroRecreativoRepositorio.deleteById(idProducto);
    }
}
