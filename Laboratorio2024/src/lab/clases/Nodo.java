package lab.clases;

import java.util.Objects;

public class Nodo {
    String id;
    String ipAddress;
    String macAddress;
    Boolean status;
    String ubicacion;
    int ipLibre;

    public Nodo(String id, String ipAddress, String macAddress, Boolean status, String ubicacion) {
        this.id = id;
        this.ipAddress = ipAddress;
        this.macAddress = macAddress;
        this.status = status;
        this.ubicacion = ubicacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nodo nodo = (Nodo) o;
        return Objects.equals(id, nodo.id) && Objects.equals(ipAddress, nodo.ipAddress) && Objects.equals(macAddress, nodo.macAddress) && Objects.equals(status, nodo.status) && Objects.equals(ubicacion, nodo.ubicacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ipAddress, macAddress, status, ubicacion);
    }

    @Override
    public String toString() {
        return "ID: " + id + ", IP: " + ipAddress + ", MAC: " + macAddress + ", Status: " + status + ", Ubicaci�n: " + ubicacion;
    }

    public int nuevaIP() {
        return ipLibre;
    }

    public String toCSV() {
        if (id.startsWith("Router") || id.startsWith("Modem")) {
            return getRouterToCSV();
        }
        return id + "," + ipAddress + "," + macAddress + "," + status + "," + ubicacion;
    }

    public String getRouterToCSV() {
        if (this instanceof Router router) {
            return id + "," + ipAddress + "," + macAddress + "," + status + "," + ubicacion + "," + router.getModelo() + "," + router.getFirmware() + "," + router.getThroughput();
        }
        return null;
    }
}
