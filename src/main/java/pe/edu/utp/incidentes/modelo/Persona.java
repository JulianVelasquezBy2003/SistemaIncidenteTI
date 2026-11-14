package pe.edu.utp.incidentes.modelo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import pe.edu.utp.incidentes.interfaces.IXMLExportable;

/*
Clase base de todos los usuarios del sistema (solicitantes, técnicos y administradores). Guarda los datos comunes y las credenciales
@author Julian
 */

public class Persona implements IXMLExportable {
    
    private String id;
    private String nombre;
    private String usuario;
    private String contraseña;
    private String correo;
    private Rol rol;

    public Persona() {
    }

    public Persona(String id, String nombre, String usuario, String contraseña, String correo, Rol rol) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.correo = correo;
        this.rol = rol;
    }
    
    //Valida las credenciales ingresadas en el login.
    public boolean validarCredenciales(String usuario, String contraseña) {
        return this.usuario.equals(usuario) && this.contraseña.equals(contraseña);
    }
    
    /*
    Convierte la persona en un elemento XML. El atributo "tipo" 
    guarda el nombre de la clase para saber qué subclase crear al leer
     */
    @Override
    public Element toXML(Document doc) {
        Element e = doc.createElement("persona");
        e.setAttribute("tipo", getClass().getSimpleName());
        e.setAttribute("id", id);
        agregarNodo(doc, e, "nombre", nombre);
        agregarNodo(doc, e, "usuario", usuario);
        agregarNodo(doc, e, "contrasena", contraseña);
        agregarNodo(doc, e, "correo", correo);
        agregarNodo(doc, e, "rol", rol.name());
        return e;
    }
    
    // Carga los datos comunes desde un elemento XML
    @Override
    public void fromXML(Element e) {
        this.id = e.getAttribute("id");
        this.nombre = leerNodo(e, "nombre");
        this.usuario = leerNodo(e, "usuario");
        this.contraseña = leerNodo(e, "contraseña");
        this.correo = leerNodo(e, "correo");
        this.rol = Rol.valueOf(leerNodo(e, "rol"));
    }

    // Crea un nodo hijo con texto y lo agrega al padre
    protected static void agregarNodo(Document doc, Element padre,String nombre, String valor) {
        Element hijo = doc.createElement(nombre);
        hijo.setTextContent(valor == null ? "" : valor);
        padre.appendChild(hijo);
    }

    // Lee el texto del primer nodo hijo con ese nombre
    protected static String leerNodo(Element padre, String nombre) {
        NodeList lista = padre.getElementsByTagName(nombre);
        return lista.getLength() > 0 ? lista.item(0).getTextContent() : "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    @Override
    public String toString() {
        return nombre;
    }
}
