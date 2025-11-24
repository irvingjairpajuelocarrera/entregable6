package smartgym.model;

import java.time.LocalDateTime;

public class Cliente {
    private String codigo;
    private String nombre;
    private int edad;
    private String correo;
    private LocalDateTime fechaCreacion;

    public Cliente(String codigo, String nombre, int edad, String correo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.fechaCreacion = LocalDateTime.now();
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getCorreo() { return correo; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEdad(int edad) { this.edad = edad; }
    public void setCorreo(String correo) { this.correo = correo; }

    @Override
    public String toString() {
        return "Cliente{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", correo='" + correo + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                '}';
    }
}
