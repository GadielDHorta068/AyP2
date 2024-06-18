/**
 * Capa con la logica de funcionamiento del programa
 */
package lab.logica;

import lab.modelo.Conexion;
import lab.modelo.Nodo;
import lab.modelo.Router;
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
    private static Map<String, Nodo> nodos;
    private static ArrayList<Conexion> conexiones;

    Graph<Nodo, Conexion> sistema;

    /**
     * Constructor de la clase Red.
     * Inicializa los mapas de nodos y la lista de conexiones.
     */
    public Red() {
        nodos = new HashMap<>();
        conexiones = new ArrayList<>();
        Graph<Nodo, Conexion> sistema = new AdjacencyMapGraph<>(false);
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

        //compruebo que la conexion sea de computadora a router o viceversa
        if (conexion.getSourceNode().getClass() != conexion.getTargetNode().getClass()) {
            conexiones.removeIf(con -> con.getTargetNode().equals(conexion.getTargetNode()));
            conexiones.add(conexion);
        }
        //compruebo que la conexion sea de router a router, asi evito el pc a pc
        if (conexion.getSourceNode().getClass() == Router.class && conexion.getTargetNode().getClass() == Router.class) {
            conexiones.removeIf(con -> con.getTargetNode().equals(conexion.getTargetNode()));
            conexiones.add(conexion);
        }
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
     * Metodo que devuelve el grafo de una red dada
     *
     * @param red Red a tratar
     * @return Graph
     */
    public Graph<Nodo, Conexion> redToGraph(Red red) {
        sistema = new AdjacencyMapGraph<>(false);
        //Mapa con los vertices de cada Nodo
        Map<Nodo, Vertex<Nodo>> vertexMap = new HashMap<>();

        // Agrego todos los nodos como verices
        for (Nodo nodo : red.getNodos().values()) {
            Vertex<Nodo> vertex = sistema.insertVertex(nodo);
            vertexMap.put(nodo, vertex);
        }

        // Conexiones a Edges
        for (Conexion conexion : red.getConexiones()) {
            Vertex<Nodo> vSource = vertexMap.get(conexion.getSourceNode());
            Vertex<Nodo> vTarget = vertexMap.get(conexion.getTargetNode());
            if (vSource != null && vTarget != null) {
                sistema.insertEdge(vSource, vTarget, conexion);
            }
        }

        imprimirGraph();
        return sistema;
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
        for (Vertex<Nodo> v : sistema.vertices()) {
            System.out.println(v.getElement().toString());
        }
        for (Edge<Conexion> c : sistema.edges()) {
            System.out.println(c.toString());
        }
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
        redToGraph(this);
        Nodo nodoOrigen = getNodos().get(origen);
        Nodo nodoDestino = getNodos().get(destino);

        if (nodoOrigen == null || nodoDestino == null) {
            return "Nodos no validos.";
        }

        if (nodoOrigen.equals(nodoDestino)) {
            return "Los nodo origen y destino son iguales";
        }
        List<Conexion> camino = corto(nodoOrigen, nodoDestino);

        StringBuilder caminoStr = new StringBuilder("Camino mas corto: ");

        for (Conexion con : camino) {
            caminoStr.append(con.getTargetNode().toString()).append(" -> ");
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
    public List<Conexion> corto(Nodo nodo1, Nodo nodo2) {
        // Copia el grafo original
        Graph<Nodo, Integer> rapido = new AdjacencyMapGraph<>(false);
        Map<Nodo, Vertex<Nodo>> res = new HashMap<>();
        Graph<Nodo, Conexion> grafo = redToGraph(this);

        // Copia los vértices
        for (Vertex<Nodo> vertex : grafo.vertices()) {
            res.put(vertex.getElement(), rapido.insertVertex(vertex.getElement()));
        }

        // Copia las aristas con el peso (bandwidth) como Integer
        for (Edge<Conexion> edge : grafo.edges()) {
            Vertex<Nodo>[] vert = grafo.endVertices(edge);
            rapido.insertEdge(res.get(vert[0].getElement()), res.get(vert[1].getElement()), edge.getElement().getBandwidth());
        }

        // Encuentra el camino más corto
        PositionalList<Vertex<Nodo>> lista = GraphAlgorithms.shortestPathList(rapido, res.get(nodo1), res.get(nodo2));
        List<Conexion> tramos = new ArrayList<>();

        // Extrae las conexiones del camino más corto
        Position<Vertex<Nodo>> aux = lista.first();
        while (lista.after(aux) != null) {
            Vertex<Nodo> v1 = aux.getElement();
            aux = lista.after(aux);
            Vertex<Nodo> v2 = aux.getElement();
            Edge<Conexion> edge = grafo.getEdge(v1, v2);
            if (edge != null) {
                tramos.add(edge.getElement());
            } else {
                // Manejar el caso en que no se encuentra una conexión entre los nodos v1 y v2
                throw new IllegalStateException("No se encontró una conexión entre " + v1.getElement() + " y " + v2.getElement());
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
    public String caminoRapido(String origen, String destino) {

        Nodo nodoOrigen = getNodos().get(origen);
        Nodo nodoDestino = getNodos().get(destino);

        redToGraph(this);
        if (nodoOrigen == null || nodoDestino == null) {
            return "Nodos no validos.";
        }

        if (nodoOrigen.equals(nodoDestino)) {
            return "Los nodo origen y destino son iguales";
        }
        List<Conexion> camino = rapido(nodoOrigen, nodoDestino);

        StringBuilder caminoStr = new StringBuilder("Camino mas rapido: ");

        for (Conexion con : camino) {
            caminoStr.append(con.getTargetNode().toString()).append(" -> ");
        }

        caminoStr.setLength(caminoStr.length() - 4);
        return caminoStr.toString();
    }

    /**
     * Devuelve una lista con el camino mas rapido de conexiones entre dos nodos
     *
     * @param nodo1 Nodo origen
     * @param nodo2 Nodo destino
     * @return List
     */
    public List<Conexion> rapido(Nodo nodo1, Nodo nodo2) {
        // Copia el grafo original
        Graph<Nodo, Integer> rapido = new AdjacencyMapGraph<>(false);
        Map<Nodo, Vertex<Nodo>> res = new HashMap<>();
        Graph<Nodo, Conexion> grafo = sistema;

        // Copia los vértices
        for (Vertex<Nodo> vertex : grafo.vertices()) {
            res.put(vertex.getElement(), rapido.insertVertex(vertex.getElement()));
        }

        // Copia las aristas con el peso (bandwidth) como Integer
        for (Edge<Conexion> edge : grafo.edges()) {
            Vertex<Nodo>[] vert = grafo.endVertices(edge);
            rapido.insertEdge(res.get(vert[0].getElement()), res.get(vert[1].getElement()), edge.getElement().getBandwidth());
        }

        // Encuentra el camino más corto
        PositionalList<Vertex<Nodo>> lista = GraphAlgorithms.shortestPathList(rapido, res.get(nodo1), res.get(nodo2));
        List<Conexion> tramos = new ArrayList<>();

        // Extrae las conexiones del camino más corto
        Position<Vertex<Nodo>> aux = lista.first();
        while (lista.after(aux) != null) {
            Vertex<Nodo> v1 = aux.getElement();
            aux = lista.after(aux);
            Vertex<Nodo> v2 = aux.getElement();
            Edge<Conexion> edge = grafo.getEdge(v1, v2);
            if (edge != null) {
                tramos.add(edge.getElement());
            } else {
                throw new IllegalStateException("No se encontró una conexión entre " + v1.getElement() + " y " + v2.getElement());
            }
        }

        return tramos;
    }


}
