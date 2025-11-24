package smartgym.model;

import java.time.LocalDateTime;

public class Entrenador {
    private String codigo;
    private String nombre;
    private String correo;
    private String especialidad;
    private LocalDateTime fechaCreacion;

    public Entrenador(String codigo, String nombre, String correo, String especialidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.correo = correo;
        this.especialidad = especialidad;
        this.fechaCreacion = LocalDateTime.now();
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public String getEspecialidad() { return especialidad; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCorreo(String correo) { this.correo = correo; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    @Override
    public String toString() {
        return "Entrenador{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                '}';
    }
}
