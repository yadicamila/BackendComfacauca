package comfacauca.servicio.implentaciones;

import comfacauca.modelo.Afiliado;
import comfacauca.modelo.CentroRecreativo;
import comfacauca.repositorio.AfiliadoRepositorio;
import comfacauca.servicio.IAfiliadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AfiliadoServicio implements IAfiliadoServicio {

    @Autowired
    private AfiliadoRepositorio AfiliadoRepositorio;

    @Override
    public List<Afiliado> ListarAfiliados() {
        return AfiliadoRepositorio.findAll();
    }


    public List<Afiliado> buscarAfiliadoPorCedula(String numerodocumento) {
        List<Afiliado> afiliado = this.AfiliadoRepositorio.findByNumerodocumento(numerodocumento);
        return afiliado;
    }
}
