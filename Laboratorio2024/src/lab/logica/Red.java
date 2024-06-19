/**
 * Capa con la logica de funcionamiento del programa
 */
package lab.logica;

import lab.modelo.Conexion;
import lab.modelo.Nodo;
import net.datastructures.*;

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

    private static Graph<Nodo, Conexion> sistema;
    private static TreeMap<String, Vertex<Nodo>> vertices;

    /**
     * Constructor de la clase Red.
     * Inicializa los mapas de nodos y la lista de conexiones.
     */
    public Red() {
        sistema = new AdjacencyMapGraph<>(false);
        vertices = new TreeMap<>();
    }

    /**
     * Agrega un nodo a la red
     *
     * @param nodo El nodo a agregar
     */
    public void agregarNodo(Nodo nodo) {
        Vertex<Nodo> vertex = sistema.insertVertex(nodo);
        vertices.put(nodo.getId(), vertex);
    }

    /**
     * Agrega una conexion a la red.
     *
     * @param conexion La conexion a agregar
     */
    public void agregarConexion(Conexion conexion) {
        Vertex<Nodo> sourceVertex = vertices.get(conexion.getSourceNode().getId());
        Vertex<Nodo> targetVertex = vertices.get(conexion.getTargetNode().getId());

        if (sourceVertex != null && targetVertex != null) {
            for (Edge<Conexion> con : sistema.edges()) {
                if (con == conexion) {
                    //figurita repetida
                    sistema.removeEdge(sistema.getEdge(sourceVertex, targetVertex));
                }
            }
            sistema.insertEdge(sourceVertex, targetVertex, conexion);

        }
    }

    /**
     * Elimina un Nodo de la red.
     *
     * @param nodoId El nodo a ser eliminado.
     */
    public void eliminarNodo(String nodoId) {
        Vertex<Nodo> vertex = vertices.remove(nodoId);
        if (vertex != null) {
            sistema.removeVertex(vertex);
        }
    }

    /**
     * Elimina una conexion existente donde exista nodo origen y destino
     *
     * @param sourceId El nodo origen
     * @param targetId El nodo Objetivo
     */
    public void eliminarConexion(String sourceId, String targetId) {
        Vertex<Nodo> sourceVertex = vertices.get(sourceId);
        Vertex<Nodo> targetVertex = vertices.get(targetId);

        if (sourceVertex != null && targetVertex != null) {
            sistema.removeEdge(sistema.getEdge(sourceVertex, targetVertex));
        }
    }

    /**
     * Imprime en consola una lista de todos los nodos existentes.
     */
    public void imprimirNodos() {
        System.out.println("Lista de Nodos:");
        for (Vertex<Nodo> vertex : sistema.vertices()) {
            System.out.println(vertex.getElement());
        }
    }

    /**
     * Imprime en consola todas las conexiones existentes.
     */
    public void imprimirConexiones() {
        System.out.println("Lista de Conexiones:");
        for (Edge<Conexion> conexion : sistema.edges()) {
            System.out.println(conexion.getElement().toString());
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

        for (Vertex<Nodo> vertex : sistema.vertices()) {
            Nodo nodo = vertex.getElement();
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
        Vertex<Nodo> vertex = vertices.get(id);
        if (vertex != null) {
            Nodo nodo = vertex.getElement();
            if (nodo.getStatus()) {
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
    public TreeMap<String, Vertex<Nodo>> getNodos() {
        return vertices;
    }

    /**
     * Getter de conexiones existentes
     *
     * @return ArrayList
     */
    public List<Conexion> getConexiones() {
        List<Conexion> conexiones = new ArrayList<>();
        for (Edge<Conexion> conexion : sistema.edges()) {
            conexiones.add(conexion.getElement());
        }
        return conexiones;
    }

    public Vertex<Nodo> buscarVertex(Nodo nodo) {
        for (Vertex<Nodo> v : sistema.vertices()) {
            if (v.getElement().equals(nodo)) {
                return v;
            }
        }
        return null;
    }

    public void imprimirGraph() {
        imprimirNodos();
        imprimirConexiones();
    }

    /**
     * Indica el camino mas corto entre dos Nodos
     * Peligro, programadores laburando
     *
     * @param origen  idNodo Origen
     * @param destino idNodo Destino
     * @return String
     */
    public String traceroute(String origen, String destino) {
        Nodo nodoOrigen = getNodos().get(origen).getElement();
        Nodo nodoDestino = getNodos().get(destino).getElement();

        if (nodoOrigen == null || nodoDestino == null) {
            return "Nodos no validos.";
        }

        if (nodoOrigen.equals(nodoDestino)) {
            return "Los nodo origen y destino son iguales";
        }
        List<Nodo> camino = caminoMasRapido(nodoOrigen, nodoDestino);

        StringBuilder caminoStr = new StringBuilder("Camino mas corto: ");

        for (Nodo nodo : camino) {
            caminoStr.append(nodo.getId()).append(" -> ");
        }

        caminoStr.setLength(caminoStr.length() - 4);
        return caminoStr.toString();
    }

    /**
     * Devuelve una lista de conexiones con el camino mas corto entre dos nodos
     *
     * @param nodo1 Nodo de origen
     * @param nodo2 Nodo de destino
     * @return List
     */
    public List<Nodo> caminoMasRapido(Nodo nodo1, Nodo nodo2) {
        // Copia el grafo original
        Graph<Nodo, Integer> rapido = new AdjacencyMapGraph<>(false);
        Map<Nodo, Vertex<Nodo>> res = new HashMap<>();

        // Copia los vértices
        for (Vertex<Nodo> vertex : sistema.vertices()) {
            res.put(vertex.getElement(), rapido.insertVertex(vertex.getElement()));
        }

        // Copia las aristas con el peso (bandwidth) como Integer
        for (Edge<Conexion> edge : sistema.edges()) {
            Vertex<Nodo>[] vert = sistema.endVertices(edge);
            rapido.insertEdge(res.get(vert[0].getElement()), res.get(vert[1].getElement()), edge.getElement().getBandwidth());
        }

        // Encuentra el camino más corto
        PositionalList<Vertex<Nodo>> lista = GraphAlgorithms.shortestPathList(rapido, res.get(nodo1), res.get(nodo2));
        List<Nodo> tramos = new ArrayList<>();

        // Extrae las conexiones del camino más corto
        Position<Vertex<Nodo>> aux = lista.first();
        tramos.addFirst(lista.first().getElement().getElement());

        while (lista.after(aux) != null) {
            aux = lista.after(aux);
            if (lista.first().getElement().getElement().getId().equals(nodo1.getId()) && lista.last().getElement().getElement().getId().equals(nodo2.getId()) ||
                    lista.first().getElement().getElement().getId().equals(nodo2.getId()) && lista.last().getElement().getElement().getId().equals(nodo1.getId())) {
                tramos.add(aux.getElement().getElement());
            } else {
                // Manejar el caso en que no se encuentra una conexión entre los nodos
                throw new IllegalStateException("No se encontró una conexión entre " + nodo1.getId() + " y " + nodo2.getId());
            }
        }

        return tramos;
    }

    /**
     * Indica el camino mas rapido (mejor ancho de banda) de un nodo origen a un nodo destino
     * Peligro, programador chambeando
     *
     * @param origen  id del nodo origen
     * @param destino id del nodo destino
     * @return String
     */
    public String arbolPesoMinimo(String origen, String destino) {

        Nodo nodoOrigen = getNodos().get(origen).getElement();
        Nodo nodoDestino = getNodos().get(destino).getElement();

        if (nodoOrigen == null || nodoDestino == null) {
            return "Nodos no validos.";
        }

        if (nodoOrigen.equals(nodoDestino)) {
            return "Los nodo origen y destino son iguales";
        }
        List<Conexion> camino = MST(sistema);

        StringBuilder caminoStr = new StringBuilder("Camino mas rapido: ");

        for (Conexion con : camino) {
            caminoStr.append(con.getTargetNode().toString()).append(" -> ");
        }

        caminoStr.setLength(caminoStr.length() - 4);
        return caminoStr.toString();
    }

    /**
     * MST
     *
     * @param sistema
     * @return List
     */
    public List<Conexion> MST(Graph<Nodo, Conexion> sistema) {
        // Copia el grafo original
        Graph<Nodo, Integer> rapido = new AdjacencyMapGraph<>(false);
        Map<Nodo, Vertex<Nodo>> res = new HashMap<>();

        // Copia los vértices
        for (Vertex<Nodo> vertex : Red.sistema.vertices()) {
            res.put(vertex.getElement(), rapido.insertVertex(vertex.getElement()));
        }

        // Copia las aristas con el peso (bandwidth) como Integer
        for (Edge<Conexion> edge : Red.sistema.edges()) {
            Vertex<Nodo>[] vert = Red.sistema.endVertices(edge);
            rapido.insertEdge(res.get(vert[0].getElement()), res.get(vert[1].getElement()), edge.getElement().getBandwidth());
        }

        // Encuentra el Arbol de expansion Minima
        PositionalList<Edge<Integer>> lista = GraphAlgorithms.MST(rapido);
        List<Conexion> tramos = new ArrayList<>();

        Position<Edge<Integer>> aux = lista.first();

        while (lista.after(aux) != null) {
            aux = lista.after(aux);
            //tramos.add(aux.getElement());

        }

        return tramos;
    }
}
