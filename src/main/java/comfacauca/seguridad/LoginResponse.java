package comfacauca.seguridad;

import comfacauca.modelo.Taquillero;

public class LoginResponse {
    private String message;
    private Taquillero taquillero;

    public LoginResponse(String message, Taquillero taquillero) {
        this.message = message;
        this.taquillero = taquillero;
    }

    // Getters y Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Taquillero getTaquillero() {
        return taquillero;
    }

    public void setTaquillero(Taquillero taquillero) {
        this.taquillero = taquillero;
    }
}
