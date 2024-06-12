package comfacauca.servicio;

import comfacauca.modelo.Afiliado;
import comfacauca.modelo.Beneficiario;

import java.util.List;

public interface IBeneficiarioServicio {

    public List<Beneficiario> ListarBeneficiarios();

    public List<Beneficiario> obtenerBeneficiariosPorIdAfiliado(Integer idAfiliado);
}
