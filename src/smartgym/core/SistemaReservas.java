package smartgym.core;

import smartgym.model.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Pattern;

public class SistemaReservas {

    private Map<String, Cliente> clientes = new HashMap<>();
    private Map<String, Entrenador> entrenadores = new HashMap<>();
    private List<Reserva> reservas = new ArrayList<>();

    private GestorLog gestorLog;
    private boolean adminLogueado = false;

    private static final Pattern CORREO_VALIDO =
            Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");

    public SistemaReservas(GestorLog gestorLog) {
        this.gestorLog = gestorLog;
    }

    // =============== SESIÓN ADMIN ===============
    public boolean iniciarSesion(String user, String pass) {
        if (user.equals("admin") && pass.equals("admin123")) {
            adminLogueado = true;
            System.out.println("Inicio de sesión exitoso.");
            return true;
        }
        System.out.println("Credenciales incorrectas.");
        return false;
    }

    public void cerrarSesion() {
        adminLogueado = false;
        System.out.println("Sesión cerrada.");
    }

    // =============== VALIDACIONES ===============
    private void validarCorreo(String correo) {
        if (!CORREO_VALIDO.matcher(correo).matches()) {
            throw new IllegalArgumentException("Correo inválido");
        }
    }

    private void validarEdad(int edad) {
        if (edad < 15) {
            throw new IllegalArgumentException("Edad mínima: 15 años");
        }
    }

    // =============== CLIENTES ===============
    public void registrarCliente(String codigo, String nombre, int edad, String correo) {
        try {
            if (clientes.containsKey(codigo)) {
                throw new IllegalArgumentException("Código de cliente ya existe.");
            }
            validarEdad(edad);
            validarCorreo(correo);

            clientes.put(codigo, new Cliente(codigo, nombre, edad, correo));
            System.out.println("Cliente registrado.");

        } catch (Exception e) {
            gestorLog.registrarError(e.getMessage());
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes.");
            return;
        }
        System.out.println("\n=== CLIENTES ===");
        clientes.values().forEach(System.out::println);
    }

    // =============== ENTRENADORES ===============
    public void registrarEntrenador(String codigo, String nombre, String correo, String especialidad) {
        try {
            if (!adminLogueado)
                throw new IllegalStateException("Solo admin puede registrar entrenadores.");

            if (entrenadores.containsKey(codigo))
                throw new IllegalArgumentException("Código ya existe.");

            validarCorreo(correo);

            entrenadores.put(codigo, new Entrenador(codigo, nombre, correo, especialidad));
            System.out.println("Entrenador registrado.");

        } catch (Exception e) {
            gestorLog.registrarError(e.getMessage());
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void listarEntrenadores() {
        if (entrenadores.isEmpty()) {
            System.out.println("No hay entrenadores.");
            return;
        }
        System.out.println("\n=== ENTRENADORES ===");
        entrenadores.values().forEach(System.out::println);
    }

    // =============== RESERVAS ===============
    public void crearReserva(String id, String codCliente, String codEntrenador, LocalDateTime fechaHora) {
        try {
            Cliente c = clientes.get(codCliente);
            Entrenador e = entrenadores.get(codEntrenador);

            if (c == null) throw new IllegalArgumentException("Cliente no existe.");
            if (e == null) throw new IllegalArgumentException("Entrenador no existe.");
            if (fechaHora.isBefore(LocalDateTime.now()))
                throw new IllegalArgumentException("Fecha pasada no permitida.");

            for (Reserva r : reservas) {
                if (r.getEntrenador().getCodigo().equals(codEntrenador)
                        && r.getFechaHora().equals(fechaHora))
                    throw new IllegalArgumentException("Entrenador ocupado.");
            }

            reservas.add(new Reserva(id, c, e, fechaHora));
            System.out.println("Reserva creada.");

        } catch (Exception ex) {
            gestorLog.registrarError(ex.getMessage());
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public void listarReservas() {
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas.");
            return;
        }
        System.out.println("\n=== RESERVAS ===");
        reservas.forEach(System.out::println);
    }
}
