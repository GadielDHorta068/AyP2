/**
 * Capa con la logica de funcionamiento del programa
 */
package lab.logica;

import lab.modelo.Conexion;
import lab.modelo.Nodo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * La clase Red representa una red de nodos y conexiones.
 * Proporciona metodos para agregar nodos y conexiones,
 * y encontrar el camino mas corto entre dos nodos utilizando el algoritmo de Dijkstra.(Proximamente)
 */

public class Red {
    private static Map<String, Nodo> nodos;
    private static ArrayList<Conexion> conexiones;

    /**
     * Constructor de la clase Red.
     * Inicializa los mapas de nodos y la lista de conexiones.
     */
    public Red() {
        nodos = new HashMap<>();
        conexiones = new ArrayList<>();
    }

    /**
     * Agrega un nodo a la red
     *
     * @param nodo El nodo a agregar
     */
    public void agregarNodo(Nodo nodo) {
        nodos.put(nodo.getId(), nodo);
    }

    /**
     * Agrega una conexion a la red.
     *
     * @param conexion La conexion a agregar
     */
    public void agregarConexion(Conexion conexion) {
        conexiones.removeIf(con -> con.getTargetNode().equals(conexion.getTargetNode()));
        conexiones.add(conexion);
    }

    /**
     * Elimina un Nodo de la red.
     *
     * @param nodoId El nodo a ser eliminado.
     */
    public void eliminarNodo(String nodoId) {
        nodos.remove(nodoId);
        conexiones.removeIf(conexion -> conexion.getSourceNode().getId().equals(nodoId) || conexion.getTargetNode().getId().equals(nodoId));
    }

    /**
     * Elimina una conexion existente donde exista nodo origen y destino
     *
     * @param sourceId El nodo origen
     * @param targetId El nodo Objetivo
     */
    public void eliminarConexion(String sourceId, String targetId) {
        conexiones.removeIf(conexion -> conexion.getSourceNode().getId().equals(sourceId) && conexion.getTargetNode().getId().equals(targetId));
    }

    /**
     * Imprime en consola una lista de todos los nodos existentes.
     */
    public void imprimirNodos() {
        System.out.println("Lista de Nodos:");
        for (Nodo nodo : nodos.values()) {
            System.out.println(nodo);
        }
    }

    /**
     * Imprime en consola todas las conexiones existentes.
     */
    public void imprimirConexiones() {
        System.out.println("Lista de Conexiones:");
        for (Conexion conexion : conexiones) {
            System.out.println(conexion);
        }
    }

    /**
     * Devuelve un boolean indicando si existe o no el nodo indicado
     *
     * @param ipAddress Direccion IP del nodo buscado
     * @return boolean
     */
    public boolean ping(String ipAddress) {
        if (!ipAddress.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}")) {
            return false;
        }

        for (Nodo nodo : nodos.values()) {
            if (nodo.getIpAddress().equals(ipAddress) && nodo.getStatus()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Busca por id un nodo
     *
     * @param id Descripcion del nodo buscado
     * @return Nodo existente y activo
     */
    public Nodo buscar(String id) {
        for (Nodo nodo : nodos.values()) {
            if (nodo.getId().equals(id) && nodo.getStatus()) {
                return nodo;
            }
        }
        return null;
    }

    /**
     * Getter de la variable nodos
     *
     * @return Map
     */
    public Map<String, Nodo> getNodos() {
        return nodos;
    }

    /**
     * Getter de conexiones existentes
     *
     * @return ArrayList
     */
    public ArrayList<Conexion> getConexiones() {
        return conexiones;
    }

    /**
     * Indica el camino mas rapido (mejor ancho de banda) de un nodo origen a un nodo destino
     * Peligro, programadores laburando
     *
     * @param origen  idNodo Origen
     * @param destino idNodo Destino
     * @return String
     */
    public String traceroute(String origen, String destino) {
        if (getNodos().get(origen).equals(getNodos().get(destino))) return "Los nodo origen y destino iguales";
        if (origen != null && destino != null) {
            //ACA EL CAMINO Y EL METODO
            List<String> ruta = new ArrayList<>();
            List<Nodo> camino = busquedaRuta(origen, destino, ruta, new ArrayList<>()); // Lista de nodos camino
            StringBuilder caminoStr = new StringBuilder("Camino mas corto: ");
            for (Nodo nodo : camino) {
                caminoStr.append(nodo.getId()).append(" -> ");
            }
            caminoStr.setLength(caminoStr.length() - 4);
            return caminoStr.toString();
        } else {
            return "Nodos no validos.";
        }
    }

    private List<Nodo> busquedaRuta(String actual, String destino, List<String> ruta, List<String> visitados) {
        ruta.add(actual);
        visitados.add(actual);
        List<Nodo> rutaNodos = new ArrayList<>();
        rutaNodos.add(getNodos().get("actual"));

        for (Conexion conexion : conexiones) {

        }
        return rutaNodos;
    }


}
