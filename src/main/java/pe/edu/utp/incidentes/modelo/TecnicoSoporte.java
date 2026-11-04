package pe.edu.utp.incidentes.modelo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Técnico de soporte con una especialidad y un contador de carga de trabajo
 * (tickets activos asignados).
 *
 * @author Tu Nombre
 */
public class TecnicoSoporte extends Persona {

    private Especialidad especialidad;
    private int cargaActual;

    public TecnicoSoporte() {
    }

    public TecnicoSoporte(String id, String nombre, String usuario, String contrasena,
                          String correo, Especialidad especialidad) {
        super(id, nombre, usuario, contrasena, correo, Rol.TECNICO);
        this.especialidad = especialidad;
        this.cargaActual = 0;
    }

    /** Suma un ticket a la carga del técnico (al asignarle un caso). */
    public void incrementarCarga() {
        cargaActual++;
    }

    /** Resta un ticket a la carga (al resolver o reasignar). Nunca baja de 0. */
    public void disminuirCarga() {
        if (cargaActual > 0) {
            cargaActual--;
        }
    }

    @Override
    public Element toXML(Document doc) {
        Element e = super.toXML(doc);
        agregarNodo(doc, e, "especialidad", especialidad.name());
        agregarNodo(doc, e, "cargaActual", String.valueOf(cargaActual));
        return e;
    }

    @Override
    public void fromXML(Element e) {
        super.fromXML(e);
        this.especialidad = Especialidad.valueOf(leerNodo(e, "especialidad"));
        this.cargaActual = Integer.parseInt(leerNodo(e, "cargaActual"));
    }

    public Especialidad getEspecialidad() { return especialidad; }
    public void setEspecialidad(Especialidad especialidad) { this.especialidad = especialidad; }

    public int getCargaActual() { return cargaActual; }
    public void setCargaActual(int cargaActual) { this.cargaActual = cargaActual; }
}