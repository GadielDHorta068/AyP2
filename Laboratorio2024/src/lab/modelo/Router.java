package lab.modelo;


public class Router extends Nodo {
    String modelo;
    String firmware;
    int throughput;
    int ipLibre = 0;

    public Router(String id, String ipAddress, String macAddress, Boolean status, String ubicacion, String modelo, String firmware, int throughput) {
        super(id, ipAddress, macAddress, status, ubicacion);
        this.modelo = modelo;
        this.firmware = firmware;
        this.throughput = throughput; //Velocidadmaxima en Megabytes. ej.
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFirmware() {
        return firmware;
    }

    public void setFirmware(String firmware) {
        this.firmware = firmware;
    }

    public int getThroughput() {
        return throughput;
    }

    public void setThroughput(int throughput) {
        this.throughput = throughput;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", IP: " + ipAddress + ", MAC: " + macAddress + ", Status: " + status + ", Ubicación: " + ubicacion + ", Modelo: " + modelo + ", Firmware: " + firmware + ", Throughput: " + throughput + " Mbps";
    }

    @Override
    public int nuevaIP() {
        ipLibre = ipLibre + 1;
        return ipLibre;
    }

}
