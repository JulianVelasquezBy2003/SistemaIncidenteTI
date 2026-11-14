package pe.edu.utp.incidentes;

import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;
import pe.edu.utp.incidentes.modelo.Cliente;
import pe.edu.utp.incidentes.modelo.Especialidad;
import pe.edu.utp.incidentes.modelo.Persona;
import pe.edu.utp.incidentes.modelo.Rol;
import pe.edu.utp.incidentes.modelo.TecnicoSoporte;
import pe.edu.utp.incidentes.modelo.TipoCliente;
import pe.edu.utp.incidentes.vista.Login;

/**
 * Punto de entrada del sistema. Carga el personal y muestra el login
 * @author Julian
 */
public class SistemaIncidenteTI {

    // Datos de prueba. TODO: reemplazar por la carga desde personal.xml
    private static List<Persona> cargarPersonal() {
        List<Persona> lista = new ArrayList<>();
        lista.add(new Cliente("P001", "Angela Cano", "Angel", "1234",
                "atorres@utp.edu.pe", TipoCliente.ESTUDIANTE));
        lista.add(new TecnicoSoporte("T001", "Julian Velasquez", "Julian", "120703",
                "lquispe@utp.edu.pe", Especialidad.HARDWARE));
        lista.add(new Persona("A001", "Administrador General", "admin", "admin123",
                "admin@utp.edu.pe", Rol.ADMIN));
        return lista;
    }

    public static void main(String[] args) {
        List<Persona> personal = cargarPersonal();
        // Mostrar el login de forma segura en el hilo de Swing
        SwingUtilities.invokeLater(() -> {
            Login ventanaLogin = new Login(personal);
            ventanaLogin.setLocationRelativeTo(null); // centra la ventana
            ventanaLogin.setVisible(true);
        });
    }
}