package lab;

public class Conexion {
    Nodo sourceNode;
    Nodo targetNode;
    String tipoConexion;
    int bandwidth;
    int latencia;
    Boolean status;
    double errorRate; // Tasa de errores en % perdida de packetes


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

    public Nodo getSourceNode() {
        return sourceNode;
    }

    public void setSourceNode(Nodo sourceNode) {
        this.sourceNode = sourceNode;
    }

    public Nodo getTargetNode() {
        return targetNode;
    }

    public void setTargetNode(Nodo targetNode) {
        this.targetNode = targetNode;
    }

    public String getTipoConexion() {
        return tipoConexion;
    }

    public void setTipoConexion(String tipoConexion) {
        this.tipoConexion = tipoConexion;
    }

    public int getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(int bandwidth) {
        this.bandwidth = bandwidth;
    }

    public int getLatencia() {
        return latencia;
    }

    public void setLatencia(int latencia) {
        this.latencia = latencia;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getErrorRate() {
        return errorRate;
    }

    public void setErrorRate(double errorRate) {
        this.errorRate = errorRate;
    }

    @Override
    public String toString() {
        return "Source: " + sourceNode.id + ", Target: " + targetNode.id + ", Tipo: " + tipoConexion + ", Bandwidth: " + bandwidth + " Mbps, Latencia: " + latencia + " ms, Status: " + status + ", Error Rate: " + errorRate + " %";
    }
}
