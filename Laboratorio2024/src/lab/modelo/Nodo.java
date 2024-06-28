package lab.modelo;

import java.util.Objects;

/**
 * Clase que luego sera heredada por Computadora y Router, ambos comparten todas las variables y metodos aqui usados
 */
public abstract class Nodo {
    private String id;
    private String ipAddress;
    private String macAddress;
    private Boolean status;
    private String ubicacion;
    private int ipLibre;

    /**
     * Constructor de Nodo
     *
     * @param id         Nombre del Nodo
     * @param ipAddress  Direccion IP a asignar
     * @param macAddress Direccion MAC a obtener
     * @param status     Nodo Activo o Inactivo
     * @param ubicacion  Ubicacion Fisica del dispositivo
     */
    public Nodo(String id, String ipAddress, String macAddress, Boolean status, String ubicacion) {
        this.id = id;
        this.ipAddress = ipAddress;
        this.macAddress = macAddress;
        this.status = status;
        this.ubicacion = ubicacion;
    }

    /**
     * Getter Descripcion
     *
     * @return String
     */
    public String getId() {
        return id;
    }

    /**
     * Set descripcion
     *
     * @param id Descripcion
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter de direccion IP
     *
     * @return String
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * Set direccion IP
     *
     * @param ipAddress IP asignada
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * Getter de direccion MAC
     *
     * @return String
     */
    public String getMacAddress() {
        return macAddress;
    }

    /**
     * Set direccion MAC
     *
     * @param macAddress MAC a asignar
     */
    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
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
     * Set status del Nodo
     *
     * @param status Estado del nodo
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * Set ubicacion del nodo
     *
     * @return String
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * Set ubicacion
     *
     * @param ubicacion Ubicacion del nodo
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * Metodo equals para saber si un nodo es equivalente a otro nodo
     *
     * @param o nodo other a comparar
     * @return Boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nodo nodo = (Nodo) o;
        return Objects.equals(id, nodo.id);
    }

    /**
     * Metodo autogenerado
     *
     * @return E
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, ipAddress, macAddress, status, ubicacion);
    }

    /**
     * Variables del nodo a String
     *
     * @return String
     */
    @Override
    public String toString() {
        return "ID: " + id + ", IP: " + ipAddress + ", MAC: " + macAddress + ", Status: " + status + ", Ubicacion: " + ubicacion;
    }

    /**
     * Retorna la proxima ip Libre
     *
     * @return int
     */
    public int nuevaIP() {
        return ipLibre;
    }

    /**
     * Metodo a CSV
     *
     * @return String
     */
    public String toCSV() {
        if (id.startsWith("Router") || id.startsWith("Modem")) {
            return getRouterToCSV();
        }
        return id + "," + ipAddress + "," + macAddress + "," + status + "," + ubicacion;
    }

    /**
     * Si el nodo es un router, lo convierte a CSV
     *
     * @return String
     */
    public String getRouterToCSV() {
        if (this instanceof Router router) {
            return id + "," + ipAddress + "," + macAddress + "," + status + "," + ubicacion + "," + router.getModelo() + "," + router.getFirmware() + "," + router.getThroughput();
        }
        return null;
    }
}
