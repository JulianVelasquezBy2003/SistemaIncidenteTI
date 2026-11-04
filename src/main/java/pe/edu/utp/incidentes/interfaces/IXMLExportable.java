package pe.edu.utp.incidentes.interfaces;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Contrato para las clases de negocio que se guardan y cargan desde XML.
 * Toda clase que la implemente debe saber convertirse a un nodo XML
 * y reconstruirse desde uno.
 *
 * @author Julian
 */

public interface IXMLExportable {
    
    /**
     * Serializa el objeto: lo convierte en un elemento XML.
     * @param doc documento XML donde se creará el elemento
     * @return elemento XML con los datos del objeto
     */
    Element toXML(Document doc);

    /**
     * Deserializa: carga los atributos del objeto desde un elemento XML.
     * @param elemento nodo XML leído del archivo
     */
    void fromXML(Element elemento);
    
}
