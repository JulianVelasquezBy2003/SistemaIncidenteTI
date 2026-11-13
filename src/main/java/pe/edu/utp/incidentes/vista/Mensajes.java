package pe.edu.utp.incidentes.vista;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 * Mensajes de diálogo reutilizables por todos los formularios del sistema.
 *
 * @author Julian
 */
public final class Mensajes {

    private Mensajes() {
        // Clase de utilidad: no se instancia
    }

    /** Muestra un mensaje informativo. */
    public static void info(Component padre, String mensaje) {
        JOptionPane.showMessageDialog(padre, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    /** Muestra una advertencia (por ejemplo, un campo obligatorio vacío). */
    public static void advertencia(Component padre, String mensaje) {
        JOptionPane.showMessageDialog(padre, mensaje, "Datos incompletos", JOptionPane.WARNING_MESSAGE);
    }

    /** Muestra un mensaje de error. */
    public static void error(Component padre, String mensaje) {
        JOptionPane.showMessageDialog(padre, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Pregunta Sí/No al usuario.
     * @return true si el usuario eligió "Sí"
     */
    public static boolean confirmar(Component padre, String pregunta) {
        int opcion = JOptionPane.showConfirmDialog(padre, pregunta, "Confirmar",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return opcion == JOptionPane.YES_OPTION;
    }

    /**
     * Aviso temporal para acciones cuyo botón ya está diseñado pero que
     * todavía no se conectan con los repositorios y archivos XML.
     */
    public static void pendiente(Component padre, String accion) {
        JOptionPane.showMessageDialog(padre,
                "La acción \"" + accion + "\" todavía no está conectada con la capa de datos (XML).",
                "Pendiente de implementar", JOptionPane.INFORMATION_MESSAGE);
    }
}
