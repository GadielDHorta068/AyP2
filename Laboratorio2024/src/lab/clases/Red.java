package lab.clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Red {
    private static Map<String, Nodo> nodos;
    private static ArrayList<Conexion> conexiones;

    public Red() {
        nodos = new HashMap<>();
        conexiones = new ArrayList<>();
    }

    public void agregarNodo(Nodo nodo) {
        nodos.put(nodo.getId(), nodo);
    }

    public void agregarConexion(Conexion conexion) {
        conexiones.add(conexion);
    }

    public void eliminarNodo(String nodoId) {
        nodos.remove(nodoId);
        conexiones.removeIf(conexion -> conexion.getSourceNode().getId().equals(nodoId) || conexion.getTargetNode().getId().equals(nodoId));
    }

    public void eliminarConexion(String sourceId, String targetId) {
        conexiones.removeIf(conexion -> conexion.getSourceNode().getId().equals(sourceId) && conexion.getTargetNode().getId().equals(targetId));
    }

    public void imprimirNodos() {
        System.out.println("Lista de Nodos:");
        for (Nodo nodo : nodos.values()) {
            System.out.println(nodo);
        }
    }

    public void imprimirConexiones() {
        System.out.println("Lista de Conexiones:");
        for (Conexion conexion : conexiones) {
            System.out.println(conexion);
        }
    }

    public boolean ping(String ipAddress) {
        for (Nodo nodo : nodos.values()) {
            if (nodo.getIpAddress().equals(ipAddress) && nodo.getStatus()) {
                return true;
            }
        }
        return false;
    }

    public Nodo buscar(String id) {
        for (Nodo nodo : nodos.values()) {
            if (nodo.getId().equals(id) && nodo.getStatus()) {
                return nodo;
            }
        }
        return null;
    }

    public Map<String, Nodo> getNodos() {
        return nodos;
    }

    public ArrayList<Conexion> getConexiones() {
        return conexiones;
    }

    public List<String> traceroute(String ipAddress) {
        List<String> path = new ArrayList<>();
        return path;
    }

}
