package pe.edu.utp.incidentes.interfaces;

/**
 * Contrato para los tickets que pueden escalarse automáticamente
 * a un nivel superior cuando exceden su tiempo límite (SLA)
 * @author Julian
 */

public interface IEscalonable {
    
    /**
     * Indica si el ticket superó el tiempo máximo de atención permitido.
     * @return true si el plazo venció
     */
    boolean excedeTiempoLimite();

    /**
     * Activa el protocolo de escalamiento: cambia el estado a ESCALADO
     * y/o sube la prioridad del ticket.
     */
    void escalar();
    
}
