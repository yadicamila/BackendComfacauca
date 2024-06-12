package comfacauca.servicio.implentaciones;

import comfacauca.modelo.Beneficiario;
import comfacauca.repositorio.BeneficiarioRepositorio;
import comfacauca.servicio.IBeneficiarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeneficiarioServicio implements IBeneficiarioServicio {

    @Autowired
    private BeneficiarioRepositorio BeneficiarioRepositorio;

    @Override
    public List<Beneficiario> ListarBeneficiarios() {
        return BeneficiarioRepositorio.findAll();}

    @Override
    public List<Beneficiario> obtenerBeneficiariosPorIdAfiliado(Integer idAfiliado) {
        return BeneficiarioRepositorio.findByAfiliado_IdAfiliado(idAfiliado);
    }
}
