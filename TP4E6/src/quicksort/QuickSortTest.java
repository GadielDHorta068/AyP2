package quicksort;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class QuickSortTest {

    public static void main(String[] args) {
        // Crear una cola de ejemplo
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(3);
        queue.offer(1);
        queue.offer(4);
        queue.offer(1);
        queue.offer(5);
        queue.offer(9);
        queue.offer(2);
        queue.offer(6);
        queue.offer(5);

        // Imprimir la cola original
        System.out.println("Cola original: " + queue);

        // Llamar al método de ordenación QuickSort
        QuickSort.quickSort(queue, Comparator.naturalOrder());

        // Imprimir la cola ordenada
        System.out.println("Cola ordenada: " + queue);
    }
}
