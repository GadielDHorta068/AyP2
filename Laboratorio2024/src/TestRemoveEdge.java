import net.datastructures.AdjacencyMapGraph;
import net.datastructures.Edge;
import net.datastructures.Vertex;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestRemoveEdge {
    //Test autogenerados con el IDE IntelliJ con extension Codium
    
    @Test
    public void test_remove_existing_edge() {
        AdjacencyMapGraph<String, String> graph = new AdjacencyMapGraph<>(false);
        Vertex<String> v1 = graph.insertVertex("A");
        Vertex<String> v2 = graph.insertVertex("B");
        Edge<String> e = graph.insertEdge(v1, v2, "Edge1");
        graph.removeEdge(e);
        assertNull(graph.getEdge(v1, v2));
    }

    @Test
    public void test_remove_edge_from_list_of_edges() {
        AdjacencyMapGraph<String, String> graph = new AdjacencyMapGraph<>(false);
        Vertex<String> v1 = graph.insertVertex("A");
        Vertex<String> v2 = graph.insertVertex("B");
        Edge<String> e = graph.insertEdge(v1, v2, "Edge1");
        graph.removeEdge(e);
        assertFalse(graph.edges().iterator().hasNext());
    }

    @Test
    public void test_invalidate_edge_position_after_removal() {
        AdjacencyMapGraph<String, String> graph = new AdjacencyMapGraph<>(false);
        Vertex<String> v1 = graph.insertVertex("A");
        Vertex<String> v2 = graph.insertVertex("B");
        Edge<String> e = graph.insertEdge(v1, v2, "Edge1");
        graph.removeEdge(e);
        assertNull(((AdjacencyMapGraph<String, String>.InnerEdge<String>) e).getPosition());
    }

    @Test
    public void test_handle_directed_and_undirected_graphs() {
        AdjacencyMapGraph<String, String> undirectedGraph = new AdjacencyMapGraph<>(false);
        Vertex<String> v1 = undirectedGraph.insertVertex("A");
        Vertex<String> v2 = undirectedGraph.insertVertex("B");
        Edge<String> e1 = undirectedGraph.insertEdge(v1, v2, "Edge1");
        undirectedGraph.removeEdge(e1);
        assertNull(undirectedGraph.getEdge(v1, v2));

        AdjacencyMapGraph<String, String> directedGraph = new AdjacencyMapGraph<>(true);
        Vertex<String> v3 = directedGraph.insertVertex("C");
        Vertex<String> v4 = directedGraph.insertVertex("D");
        Edge<String> e2 = directedGraph.insertEdge(v3, v4, "Edge2");
        directedGraph.removeEdge(e2);
        assertNull(directedGraph.getEdge(v3, v4));
    }


    @Test
    public void test_remove_edge_with_no_other_edges() {
        AdjacencyMapGraph<String, String> graph = new AdjacencyMapGraph<>(false);
        Vertex<String> v1 = graph.insertVertex("A");
        Vertex<String> v2 = graph.insertVertex("B");
        Edge<String> e = graph.insertEdge(v1, v2, "Edge1");
        graph.removeEdge(e);
        assertEquals(0, graph.outDegree(v1));
        assertEquals(0, graph.outDegree(v2));
    }

    @Test
    public void test_remove_single_edge_in_graph() {
        AdjacencyMapGraph<String, String> graph = new AdjacencyMapGraph<>(false);
        Vertex<String> v1 = graph.insertVertex("A");
        Vertex<String> v2 = graph.insertVertex("B");
        Edge<String> e = graph.insertEdge(v1, v2, "Edge1");
        graph.removeEdge(e);
        assertEquals(0, graph.numEdges());
    }

    @Test
    public void test_no_other_edges_affected_on_removal() {
        AdjacencyMapGraph<String, String> graph = new AdjacencyMapGraph<>(false);
        Vertex<String> v1 = graph.insertVertex("A");
        Vertex<String> v2 = graph.insertVertex("B");
        Vertex<String> v3 = graph.insertVertex("C");
        Edge<String> e1 = graph.insertEdge(v1, v2, "Edge1");
        Edge<String> e2 = graph.insertEdge(v2, v3, "Edge2");
        graph.removeEdge(e1);
        assertNotNull(graph.getEdge(v2, v3));
    }
}
