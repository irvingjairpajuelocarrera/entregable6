package smartgym.model;

import java.time.LocalDateTime;

public class Reserva {
    private String idReserva;
    private Cliente cliente;
    private Entrenador entrenador;
    private LocalDateTime fechaHora;
    private String estado; // Activa o Cancelada

    public Reserva(String idReserva, Cliente cliente, Entrenador entrenador, LocalDateTime fechaHora) {
        this.idReserva = idReserva;
        this.cliente = cliente;
        this.entrenador = entrenador;
        this.fechaHora = fechaHora;
        this.estado = "Activa";
    }

    public String getIdReserva() { return idReserva; }
    public Cliente getCliente() { return cliente; }
    public Entrenador getEntrenador() { return entrenador; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public String getEstado() { return estado; }

    public void cancelar() {
        this.estado = "Cancelada";
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "idReserva='" + idReserva + '\'' +
                ", cliente=" + cliente.getNombre() +
                ", entrenador=" + entrenador.getNombre() +
                ", fechaHora=" + fechaHora +
                ", estado='" + estado + '\'' +
                '}';
    }
}
