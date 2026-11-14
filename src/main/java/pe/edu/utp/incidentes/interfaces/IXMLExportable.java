package pe.edu.utp.incidentes.interfaces;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Contrato para las clases de negocio que se guardan y cargan desde XML.
 * Toda clase que la implemente debe saber convertirse a un nodo XML
 * y reconstruirse desde uno.
 * @author Julian
 */

public interface IXMLExportable {
    
    /**
     * Serializa el objeto: lo convierte en un elemento XML.
     */
    Element toXML(Document doc);

    /**
     * Deserializa: carga los atributos del objeto desde un elemento XML.
     */
    void fromXML(Element elemento);
    
}
