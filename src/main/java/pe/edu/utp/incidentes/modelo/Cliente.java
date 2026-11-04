package pe.edu.utp.incidentes.modelo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Solicitante del servicio de TI (estudiante, docente o administrativo).
 * Hereda los datos y la persistencia de {@link Persona}.
 *
 * @author Tu Nombre
 */
public class Cliente extends Persona {

    private TipoCliente tipoCliente;

    public Cliente() {
    }

    public Cliente(String id, String nombre, String usuario, String contrasena,
                   String correo, TipoCliente tipoCliente) {
        super(id, nombre, usuario, contrasena, correo, Rol.SOLICITANTE);
        this.tipoCliente = tipoCliente;
    }

    @Override
    public Element toXML(Document doc) {
        Element e = super.toXML(doc);          // datos comunes
        agregarNodo(doc, e, "tipoCliente", tipoCliente.name());
        return e;
    }

    @Override
    public void fromXML(Element e) {
        super.fromXML(e);
        this.tipoCliente = TipoCliente.valueOf(leerNodo(e, "tipoCliente"));
    }

    public TipoCliente getTipoCliente() { return tipoCliente; }
    public void setTipoCliente(TipoCliente tipoCliente) { this.tipoCliente = tipoCliente; }
}