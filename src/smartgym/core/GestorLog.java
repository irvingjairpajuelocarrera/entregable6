package smartgym.core;

import smartgym.model.LogError;
import java.util.ArrayList;
import java.util.List;

public class GestorLog {

    private List<LogError> errores = new ArrayList<>();

    public void registrarError(String mensaje) {
        errores.add(new LogError(mensaje));
    }

    public void mostrarErrores() {
        if (errores.isEmpty()) {
            System.out.println("No hay errores en el log.");
            return;
        }
        System.out.println("\n=== LOG DE ERRORES ===");
        for (LogError e : errores) {
            System.out.println(e);
        }
    }
}
