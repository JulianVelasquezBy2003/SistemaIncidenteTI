package pe.edu.utp.incidentes;

import pe.edu.utp.incidentes.modelo.Cliente;
import pe.edu.utp.incidentes.modelo.Especialidad;
import pe.edu.utp.incidentes.modelo.Persona;
import pe.edu.utp.incidentes.modelo.Rol;
import pe.edu.utp.incidentes.modelo.TecnicoSoporte;
import pe.edu.utp.incidentes.modelo.TipoCliente;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;
import pe.edu.utp.incidentes.vista.Login;

/**
 * Punto de entrada del sistema. Carga el personal y muestra el login.
 * @author Julian
 */
public class SistemaIncidenteTI {

    public static void main(String[] args) {
        // Carga los datos (por ahora de prueba; luego vendrá de personal.xml)
        List<Persona> personal = cargarPersonal();

        // Mostrar el login de forma segura en el hilo de Swing
        SwingUtilities.invokeLater(() -> {
            Login ventanaLogin = new Login(personal);
            ventanaLogin.setLocationRelativeTo(null); // centra la ventana
            ventanaLogin.setVisible(true);
        });
    }

    private static List<Persona> cargarPersonal() {
        List<Persona> lista = new ArrayList<>();
        lista.add(new Cliente("P001", "Ana Torres", "atorres", "1234",
                "atorres@utp.edu.pe", TipoCliente.ESTUDIANTE));
        lista.add(new TecnicoSoporte("T001", "Luis Quispe", "lquispe", "abcd",
                "lquispe@utp.edu.pe", Especialidad.HARDWARE_REDES));
        lista.add(new Persona("A001", "Administrador General", "admin", "admin123",
                "admin@utp.edu.pe", Rol.ADMIN));
        return lista;
    }
}
