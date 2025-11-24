package smartgym.app;

import smartgym.core.*;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        GestorLog log = new GestorLog();
        SistemaReservas sistema = new SistemaReservas(log);
        Scanner sc = new Scanner(System.in);

        int opcion = 0;

        do {
            System.out.println("\n====== SMARTGYM ======");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Registrar entrenador");
            System.out.println("3. Crear reserva");
            System.out.println("4. Listar clientes");
            System.out.println("5. Listar entrenadores");
            System.out.println("6. Listar reservas");
            System.out.println("7. Iniciar sesión (admin)");
            System.out.println("8. Cerrar sesión");
            System.out.println("9. Ver log de errores");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1 -> {
                    System.out.print("Código cliente: ");
                    String c = sc.nextLine();
                    System.out.print("Nombre: ");
                    String n = sc.nextLine();
                    System.out.print("Edad: ");
                    int e = sc.nextInt(); sc.nextLine();
                    System.out.print("Correo: ");
                    String correo = sc.nextLine();

                    sistema.registrarCliente(c, n, e, correo);
                }

                case 2 -> {
                    System.out.print("Código entrenador: ");
                    String c = sc.nextLine();
                    System.out.print("Nombre: ");
                    String n = sc.nextLine();
                    System.out.print("Correo: ");
                    String correo = sc.nextLine();
                    System.out.print("Especialidad: ");
                    String esp = sc.nextLine();
                    sistema.registrarEntrenador(c, n, correo, esp);
                }

                case 3 -> {
                    System.out.print("ID reserva: ");
                    String id = sc.nextLine();
                    System.out.print("Código cliente: ");
                    String cc = sc.nextLine();
                    System.out.print("Código entrenador: ");
                    String ce = sc.nextLine();
                    System.out.print("Fecha (AAAA-MM-DDTHH:MM): ");
                    String fecha = sc.nextLine();

                    sistema.crearReserva(id, cc, ce, LocalDateTime.parse(fecha));
                }

                case 4 -> sistema.listarClientes();
                case 5 -> sistema.listarEntrenadores();
                case 6 -> sistema.listarReservas();

                case 7 -> {
                    System.out.print("Usuario: ");
                    String u = sc.nextLine();
                    System.out.print("Password: ");
                    String p = sc.nextLine();
                    sistema.iniciarSesion(u, p);
                }

                case 8 -> sistema.cerrarSesion();

                case 9 -> log.mostrarErrores();

                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida");
            }

        } while (opcion != 0);

        sc.close();
    }
}
