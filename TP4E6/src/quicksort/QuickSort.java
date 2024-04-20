package quicksort;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class QuickSort {

    public static <K> void quickSort(Queue<K> S, Comparator<K> comp) {

        int n = S.size();

        if (n < 2) return; // la cola está trivialmente ordenada

        // divide

        K pivot = S.peek(); // usando el primer elemento como pivote arbitrario

        Queue<K> L = new LinkedList<>();
        Queue<K> E = new LinkedList<>();
        Queue<K> G = new LinkedList<>();

        while (!S.isEmpty()) { // divide la cola original en L, E y G

            K element = S.poll();

            int c = comp.compare(element, pivot);

            if (c < 0) // el elemento es menor que el pivote
                L.offer(element);
            else if (c == 0) // el elemento es igual al pivote
                E.offer(element);
            else // el elemento es mayor que el pivote
                G.offer(element);
        }

        // conquista

        quickSort(L, comp); // ordena los elementos menores que el pivote
        quickSort(G, comp); // ordena los elementos mayores que el pivote

        // concatena los resultados
        while (!L.isEmpty())
            S.offer(L.poll());
        while (!E.isEmpty())
            S.offer(E.poll());
        while (!G.isEmpty())
            S.offer(G.poll());
    }
}
