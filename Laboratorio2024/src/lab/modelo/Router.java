package lab.modelo;

/**
 * Clase Router
 */
public class Router extends Nodo {
    String modelo;
    String firmware;
    int throughput;
    int ipLibre = 0;

    /**
     * Constructor de Router
     *
     * @param id         Nombre del Nodo
     * @param ipAddress  Direccion IP a asignar
     * @param macAddress Direccion MAC a obtener
     * @param status     Nodo Activo o Inactivo
     * @param ubicacion  Ubicacion Fisica del dispositivo
     * @param modelo     Modelo del dispositivo
     * @param firmware   Numero de firmware del dispositigo
     * @param throughput Capacidad de Ancho de banda
     */
    public Router(String id, String ipAddress, String macAddress, Boolean status, String ubicacion, String modelo, String firmware, int throughput) {
        super(id, ipAddress, macAddress, status, ubicacion);
        this.modelo = modelo;
        this.firmware = firmware;
        this.throughput = throughput; //Velocidadmaxima en Megabytes. ej.
    }

    /**
     * Getter Modelo
     *
     * @return String
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Set Modelo
     *
     * @param modelo Modelo del dispositivo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Getter firmware
     *
     * @return String
     */
    public String getFirmware() {
        return firmware;
    }

    /**
     * Set firmware
     *
     * @param firmware firmware del dispositivo
     */
    public void setFirmware(String firmware) {
        this.firmware = firmware;
    }

    /**
     * Getter Firmware
     *
     * @return int
     */
    public int getThroughput() {
        return throughput;
    }

    /**
     * Set Ancho de banda
     *
     * @param throughput Ancho de banda
     */
    public void setThroughput(int throughput) {
        this.throughput = throughput;
    }

    /**
     * To String de las variables del Router
     *
     * @return String
     */
    @Override
    public String toString() {
        return "ID: " + getId() + ", IP: " + getIpAddress() + ", MAC: " + getMacAddress() + ", Status: " + getStatus() + ", Ubicacion: " + getUbicacion() + ", Modelo: " + modelo + ", Firmware: " + firmware + ", Throughput: " + throughput + " Mbps";
    }

    /**
     * Devuelve la ip Libre
     *
     * @return int
     */
    @Override
    public int nuevaIP() {
        ipLibre = ipLibre + 1;
        return ipLibre;
    }

}
