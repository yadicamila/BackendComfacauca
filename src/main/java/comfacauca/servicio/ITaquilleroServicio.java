package comfacauca.servicio;

import comfacauca.modelo.Taquillero;

import java.util.List;

public interface ITaquilleroServicio {

    public List<Taquillero> ListarTaquilleros();

    public Taquillero login(String usuario, String contrasena);
}
