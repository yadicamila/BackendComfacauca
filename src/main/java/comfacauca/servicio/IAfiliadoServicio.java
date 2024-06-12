package comfacauca.servicio;

import comfacauca.modelo.Afiliado;
import comfacauca.modelo.CentroRecreativo;

import java.util.List;

public interface IAfiliadoServicio {

    public List<Afiliado> ListarAfiliados();

    public List<Afiliado> buscarAfiliadoPorCedula(String numerodocumento);
}
