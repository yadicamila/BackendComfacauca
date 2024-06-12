package comfacauca.servicio;

import comfacauca.modelo.Afiliado;
import comfacauca.modelo.CentroRecreativo;
import java.util.List;

public interface ICentroRecreativoServicio {
    public List<CentroRecreativo> ListarCentros();

    public CentroRecreativo buscarCentrosPorId(Integer idProducto);

    public CentroRecreativo guardarCentro(CentroRecreativo centrorecreativo);

    public void eliminarCentroPorId(Integer idProducto);

    interface ITaquilleroServicio {

        public List<Afiliado> ListarAfiliados();
    }
}
