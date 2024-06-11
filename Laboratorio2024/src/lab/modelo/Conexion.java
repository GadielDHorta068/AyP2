package lab.modelo;

import lab.logica.Utilidades;

/**
 * Clase conexion
 */
public class Conexion {
    Nodo sourceNode;
    Nodo targetNode;
    String tipoConexion;
    int bandwidth;
    int latencia;
    Boolean status;
    double errorRate; // Tasa de errores en % perdida de packetes

    /**
     * Constructor de Conexion
     *
     * @param sourceNode   Nodo origen
     * @param targetNode   Nodo destino
     * @param tipoConexion Tipo de conexion
     * @param bandwidth    Ancho de banda
     * @param latencia     Latencia de la conexion
     * @param status       Conexion activa o inactiva
     * @param errorRate    tasa de error (Packet loss)
     */
    public Conexion(Nodo sourceNode, Nodo targetNode, String tipoConexion, int bandwidth, int latencia, Boolean status, double errorRate) {
        Utilidades.asignarDireccion(sourceNode, targetNode);
        this.sourceNode = sourceNode;
        this.targetNode = targetNode;
        this.tipoConexion = tipoConexion;
        this.bandwidth = bandwidth;
        this.latencia = latencia;
        this.status = status;
        this.errorRate = errorRate;
    }

    /**
     * Getter de Nodo de origen
     *
     * @return Nodo
     */
    public Nodo getSourceNode() {
        return sourceNode;
    }

    /**
     * Set nodo de origen
     *
     * @param sourceNode Nodo de origen
     */
    public void setSourceNode(Nodo sourceNode) {
        this.sourceNode = sourceNode;
    }

    /**
     * Getter nodo destino
     *
     * @return Nodo
     */
    public Nodo getTargetNode() {
        return targetNode;
    }

    /**
     * Cambiar el nodo destino de una conexion existente
     *
     * @param targetNode Nodo destino
     */
    public void setTargetNode(Nodo targetNode) {
        this.targetNode = targetNode;
    }

    /**
     * Getter del tipo de conexion
     *
     * @return String
     */
    public String getTipoConexion() {
        return tipoConexion;
    }

    /**
     * Setear el tipo de conexion
     *
     * @param tipoConexion tipo de conexion
     */
    public void setTipoConexion(String tipoConexion) {
        this.tipoConexion = tipoConexion;
    }

    /**
     * Getter ancho de banda
     *
     * @return int
     */
    public int getBandwidth() {
        return bandwidth;
    }

    /**
     * Set ancho de banda
     *
     * @param bandwidth ancho de banda
     */
    public void setBandwidth(int bandwidth) {
        this.bandwidth = bandwidth;
    }

    /**
     * Getter de latencia
     *
     * @return int
     */
    public int getLatencia() {
        return latencia;
    }

    /**
     * Set latencia
     *
     * @param latencia latencia en la conexion
     */
    public void setLatencia(int latencia) {
        this.latencia = latencia;
    }

    /**
     * Getter status
     *
     * @return Boolean
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * Set status
     *
     * @param status estado de la conexion
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * Getter tasa de errores
     *
     * @return double
     */
    public double getErrorRate() {
        return errorRate;
    }

    /**
     * Set tasa de errores
     *
     * @param errorRate tasa de error
     */
    public void setErrorRate(double errorRate) {
        this.errorRate = errorRate;
    }

    /**
     * Devuelve un string con las variables de la clase
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Source: " + sourceNode.id + ", Target: " + targetNode.id + ", Tipo: " + tipoConexion + ", Bandwidth: " + bandwidth + " Mbps, Latencia: " + latencia + " ms, Status: " + status + ", Error Rate: " + errorRate + " %";
    }

    /**
     * Crea un String donde cada valor esta separado por una coma. (CSV Coma Separated Value)
     *
     * @return String
     */
    public String toCSV() {
        return sourceNode.id + "," + targetNode.id + "," + tipoConexion + "," + bandwidth + "," + latencia + "," + status + "," + errorRate;
    }
}
