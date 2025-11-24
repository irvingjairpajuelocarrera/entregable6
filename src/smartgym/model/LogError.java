package smartgym.model;

import java.time.LocalDateTime;

public class LogError {
    private LocalDateTime fechaHora;
    private String mensaje;

    public LogError(String mensaje) {
        this.fechaHora = LocalDateTime.now();
        this.mensaje = mensaje;
    }

    public LocalDateTime getFechaHora() { return fechaHora; }
    public String getMensaje() { return mensaje; }

    @Override
    public String toString() {
        return "[" + fechaHora + "] " + mensaje;
    }
}
