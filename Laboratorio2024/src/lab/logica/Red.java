/**
 * Capa con la logica de funcionamiento del programa
 */
package lab.logica;

import lab.modelo.Conexion;
import lab.modelo.Nodo;
import lab.modelo.Router;
import net.datastructures.TreeMap;
import net.datastructures.*;

import java.util.List;
import java.util.Map;
import java.util.*;

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

    //region MANEJO DE GRAFO, CREACION/DESTRUCCION

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
    //endregion
    //region PRINTS

    /**
     * Hace lo que dice
     */
    public void imprimirGraph() {
        imprimirNodos();
        imprimirConexiones();
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
    //endregion
    //region Incremento 2

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

        // Copia los vertices
        for (Vertex<Nodo> vertex : sistema.vertices()) {
            res.put(vertex.getElement(), rapido.insertVertex(vertex.getElement()));
        }

        // Copia las aristas con el peso (bandwidth) como Integer
        //Convertir de Ancho de Banda a Segundos al pasar 10000MB de informacion
        for (Edge<Conexion> edge : sistema.edges()) {
            Vertex<Nodo>[] vert = sistema.endVertices(edge);
            rapido.insertEdge(res.get(vert[0].getElement()), res.get(vert[1].getElement()), (10000 / edge.getElement().getBandwidth()));
        }

        // Encuentra el camino mas corto
        PositionalList<Vertex<Nodo>> lista = GraphAlgorithms.shortestPathList(rapido, res.get(nodo1), res.get(nodo2));
        List<Nodo> tramos = new ArrayList<>();

        // Extrae las conexiones del camino mas corto
        Position<Vertex<Nodo>> aux = lista.first();
        tramos.addFirst(lista.first().getElement().getElement());

        while (lista.after(aux) != null) {
            aux = lista.after(aux);

            //Aseguro no copiar cosas erroneas
            if (lista.first().getElement().getElement().getId().equals(nodo1.getId()) && lista.last().getElement().getElement().getId().equals(nodo2.getId()) ||
                    lista.first().getElement().getElement().getId().equals(nodo2.getId()) && lista.last().getElement().getElement().getId().equals(nodo1.getId())) {

                tramos.add(aux.getElement().getElement());
            } else {
                // Manejar el caso en que no se encuentra una conexion entre los nodos,
                // esto debo cambiar para que sea amigable a la interfaz. (Nunca deberia llegar aca igualmente)
                throw new IllegalStateException("No se encontro una conexion entre " + nodo1.getId() + " y " + nodo2.getId());
            }
        }

        return tramos;
    }

    /**
     * Devuelve una Lista de Conexiones entre Routers
     * de peso minimo en el grafo
     *
     * @return List
     */
    public List<Conexion> MST() {
        // Copia el grafo original
        Graph<Nodo, Integer> copy = new AdjacencyMapGraph<>(false);
        Map<Nodo, Vertex<Nodo>> res = new HashMap<>();
        // Copia los vertices
        for (Vertex<Nodo> vertex : Red.sistema.vertices()) {
            if (vertex.getElement().getClass() == Router.class) {
                res.put(vertex.getElement(), copy.insertVertex(vertex.getElement()));
            }
        }

        // Copia las aristas con el peso (bandwidth) como Integer y pasar a segundos con un Archivo de 10000MB
        for (Edge<Conexion> edge : Red.sistema.edges()) {
            if (edge.getElement().getTargetNode().getClass() == Router.class && edge.getElement().getSourceNode().getClass() == Router.class) {
                Vertex<Nodo>[] vert = Red.sistema.endVertices(edge);
                copy.insertEdge(res.get(vert[0].getElement()), res.get(vert[1].getElement()), 10000 / edge.getElement().getBandwidth());
            }
        }

        // Encuentra el Arbol de expansion Minima ------->
        PositionalList<Edge<Integer>> lista = GraphAlgorithms.MST(copy);
        List<Conexion> tramos = new ArrayList<>();

        // Extraer aristas del MST y conviertir a Conexion
        for (Position<Edge<Integer>> pos = lista.first(); pos != null; pos = lista.after(pos)) {
            Edge<Integer> edge = pos.getElement();
            Vertex<Nodo>[] vertices = copy.endVertices(edge);
            Nodo nodo1 = vertices[0].getElement();
            Nodo nodo2 = vertices[1].getElement();
            Conexion conexion = null;

            // Busca la conexion original en el grafo original
            for (Edge<Conexion> e : sistema.edges()) {
                Vertex<Nodo>[] originalVertices = sistema.endVertices(e);
                if ((originalVertices[0].getElement().equals(nodo1) && originalVertices[1].getElement().equals(nodo2)) ||
                        (originalVertices[0].getElement().equals(nodo2) && originalVertices[1].getElement().equals(nodo1))) {
                    conexion = e.getElement();
                    break;
                }
            }
            //Agrego a la lista
            if (conexion != null) {
                tramos.add(conexion);
            }
        }
        return tramos;
    }
    //endregion
    //region GETTERS SETTERS

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

    public Graph<Nodo, Conexion> getSistema() {
        return sistema;
    }

    //endregion
    //region INCREMENTO 3

    /**
     * @param n1 Nodo origen
     * @param n2 Nodo destino
     * @return int
     */
    public int flujoMaximo(Nodo n1, Nodo n2) {
        List<Nodo> camino = caminoMasRapido(n1, n2);
        PositionalList<Nodo> nodos = new LinkedPositionalList<>();
        List<Integer> flow = new ArrayList<>();

        for (Nodo n : camino) {
            nodos.addLast(n);
        }

        Position<Nodo> aux = nodos.first();
        while (nodos.after(aux) != null) {
            for (Conexion conexion : getConexiones()) {
                Vertex<Nodo> sourceVertex = vertices.get(aux.getElement().getId());
                Vertex<Nodo> targetVertex = vertices.get(nodos.after(aux).getElement().getId());

                flow.add(sistema.getEdge(sourceVertex, targetVertex).getElement().getBandwidth());
            }
            aux = nodos.after(aux);
        }

        if (!flow.isEmpty()) {
            flow.sort(Comparator.naturalOrder());
            return flow.getFirst();
        }
        return -1;
    }

    //endregion
    //region extras

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
    //endregion
}
